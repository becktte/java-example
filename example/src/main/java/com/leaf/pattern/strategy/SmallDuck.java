package com.leaf.pattern.strategy;

public class SmallDuck extends Duck {

    @Override
    public void display() {
        System.out.println("yellow flur");
    }

    public static void main(String[] args) {
        Duck duck = new SmallDuck();
        duck.setFlyBehavior(new FlyWithWings());
        duck.setQuackBehavior(new QuackWithMouse());
        duck.flyPerform();
        duck.quackPerform();
    }
}
