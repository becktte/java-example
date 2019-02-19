package com.leaf.threadlocal;

public class ThreadLocalTest {
    ThreadLocal<Long> longThreadLocal = new ThreadLocal<>();
    ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public void set() {
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    public Long getLong() {
        return longThreadLocal.get();
    }

    public String getString() {
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        threadLocalTest.set();
        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());

        Thread thread = new Thread(() -> {
            threadLocalTest.set();
            System.out.println(threadLocalTest.getLong());
            System.out.println(threadLocalTest.getString());
        });
        thread.start();
        thread.join();

        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());
    }
}
