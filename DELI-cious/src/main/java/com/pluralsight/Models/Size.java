package com.pluralsight.Models;


public class Size {
    private int inches;
    private double price;

    public Size(int inches, double price) {
        this.inches = inches;
        this.price = price;
    }

    public int getInches() {
        return inches;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return inches + "\" - $" + price;
    }
}
