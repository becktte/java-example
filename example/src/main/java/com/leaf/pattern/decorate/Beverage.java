package com.leaf.pattern.decorate;

public abstract class Beverage {
    private String description = "unknown beverage";

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract double cost();
}

