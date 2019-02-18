package com.leaf.pattern;

public class QuackSclient implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("sclient");
    }
}
