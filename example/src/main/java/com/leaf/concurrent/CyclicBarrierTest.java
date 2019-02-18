package com.leaf.concurrent;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(4,
                () -> System.out.println("所有线程操作数据库完成后触发"));
        for (int i = 0; i < 4; i++) {
            new Thread(new Writer(cyclicBarrier)).start();
        }
    }

    static class Writer implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "模拟数据库操作开始。。。");
            try {
                Thread.sleep(5000);
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "所有线程操作结束...");
        }
    }
}
