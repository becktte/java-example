package com.leaf.pattern.strategy;

public class QuackSclient implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("sclient");
    }
}
