package com.leaf.pattern.decorate;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        super.setDescription("House Blend coffee");
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
