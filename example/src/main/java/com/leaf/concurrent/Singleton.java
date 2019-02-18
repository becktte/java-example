package com.leaf.concurrent;

public class Singleton {

    private Singleton() {}

    private static class SingletonInner {
        public static Singleton singleton = new Singleton();
    }

    public static Singleton getSingleton() {
        return SingletonInner.singleton;
    }
}
