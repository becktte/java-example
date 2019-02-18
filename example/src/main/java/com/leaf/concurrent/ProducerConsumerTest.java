package com.leaf.concurrent;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerTest {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(20);
        new Thread(new Producer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
        new Thread(new Consumer(blockingQueue)).start();
    }

    static class Producer implements Runnable {
        private BlockingQueue<String> blockingQueue;

        public Producer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            Random random = new Random();
            System.out.println("启动生产者线程");
            while (true) {
                String value = String.valueOf(random.nextInt());
                System.out.println("生产者生成了" + value);
                blockingQueue.offer(value);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        private BlockingQueue<String> blockingQueue;

        public Consumer(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            System.out.println("启动消费者线程");
            while (true) {
                try {
                    String value = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + "消费者消费了" + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
