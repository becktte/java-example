package com.leaf.concurrent;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
//        new Thread(new LockOne(object1, object2)).start();
//        new Thread(new LockTwo(object1, object2)).start();

        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Thread thread1 = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 65; i < 91; i++) {
                    System.out.println("----------thread1------- " + (char) i);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                lock.lock();
                for (int i = 0; i < 26; i++) {
                    System.out.println("----------thread2------- " + i);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        });
        thread1.start();
        thread2.start();
    }

    static class LockOne implements Runnable {
       Object object1;
       Object object2;

        public LockOne(Object object1, Object object2) {
            this.object1 = object1;
            this.object2 = object2;
        }

        @Override
        public void run() {
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + "锁住了object1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println(Thread.currentThread().getName() + "锁住了object2");
                }
            }
        }
    }

    static class LockTwo implements Runnable {
        Object object1 = null;
        Object object2 = null;

        public LockTwo(Object object1, Object object2) {
            this.object1 = object1;
            this.object2 = object2;
        }

        @Override
        public void run() {
            synchronized (object2) {
                System.out.println(Thread.currentThread().getName() + "锁住了object2");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println(Thread.currentThread().getName() + "锁住了object1");
                }
            }
        }
    }

}
