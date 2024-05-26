package com.pluralsight;

public class Topping {
    private String name;
    private boolean isPremium;
    private double cost;

    public Topping(String name, boolean isPremium, double cost) {
        this.name = name;
        this.isPremium = isPremium;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}