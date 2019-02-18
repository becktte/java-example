package com.leaf.pattern;

public class FlyNoWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I cant fly");
    }
}
