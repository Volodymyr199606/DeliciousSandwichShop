package com.pluralsight;

public class Topping {
    private String name;
    private String type; // added type attribute
    private double cost;

    public Topping(String name, String type, double cost) {
        this.name = name;
        this.type = type; // set type in constructor
        this.cost = cost;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}