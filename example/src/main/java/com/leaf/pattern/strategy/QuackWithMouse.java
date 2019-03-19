package com.leaf.pattern.strategy;

public class QuackWithMouse implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack gagaga");
    }
}
