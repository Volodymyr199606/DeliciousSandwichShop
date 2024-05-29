package com.pluralsight.Models;

public class RegularTopping {
    private String name;

    public RegularTopping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return 0.0; // Regular toppings are free
    }
}
