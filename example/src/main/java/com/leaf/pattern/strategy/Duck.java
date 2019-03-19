package com.leaf.pattern.strategy;

public abstract class Duck {
    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void swim() {
        System.out.println("i'm swimming");
    }

    public void flyPerform() {
        flyBehavior.fly();
    }

    public void quackPerform() {
        quackBehavior.quack();
    }
}
