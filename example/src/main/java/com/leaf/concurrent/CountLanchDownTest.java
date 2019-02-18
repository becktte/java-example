package com.leaf.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountLanchDownTest {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i < 4; i++) {
            new Thread(new Excutor(countDownLatch)).start();
        }

        try {
            countDownLatch.await();
            System.out.println("all thread finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

     static class Excutor implements Runnable {
        private CountDownLatch countDownLatch;

        public Excutor(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "finished");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
