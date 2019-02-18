package com.leaf.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 8; i++) {
            new Thread(new Worker(semaphore)).start();
        }
    }

    static class Worker implements Runnable {
        private Semaphore semaphore;

        public Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "该工人获取到了机器的使用权限");
                Thread.sleep(3000);
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + "该工人释放了该机器的使用权限");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
