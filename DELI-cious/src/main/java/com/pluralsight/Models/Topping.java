package com.pluralsight.Models;

public class Topping {
    private String name;
    private boolean isPremium;
    private boolean isExtra;

    public Topping(String name, boolean isPremium, boolean isExtra) {
        this.name = name;
        this.isPremium = isPremium;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public double getCost(int size) {
        double cost = 0.0;
        if (isPremium) {
            switch (size) {
                case 4:
                    cost = isExtra ? 1.50 : 1.00;
                    break;
                case 8:
                    cost = isExtra ? 3.00 : 2.00;
                    break;
                case 12:
                    cost = isExtra ? 4.50 : 3.00;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid size");
            }
        }
        return cost;
    }

}