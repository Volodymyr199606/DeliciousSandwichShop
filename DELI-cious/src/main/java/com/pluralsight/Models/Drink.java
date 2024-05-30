package com.pluralsight.Models;
// Drink.java

public class Drink extends Product {
    private String size;

    public Drink(String size) {
        super("Drink", calculatePrice(size));
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    private static double calculatePrice(String size) {
        switch (size) {
            case "Small":
                return 2.00;
            case "Medium":
                return 2.50;
            case "Large":
                return 3.00;
            default:
                throw new IllegalArgumentException("Invalid size");
        }
    }

    @Override
    public String getDescription() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}
