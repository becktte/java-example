package com.leaf.pattern.strategy;

public class FlyNoWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I cant fly");
    }
}
