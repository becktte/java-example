package com.leaf.pattern.decorate;

public class Espresso extends Beverage {

    public Espresso() {
        super.setDescription("Espresso");
    }

    @Override
    public double cost() {
        return 1.5;
    }
}
