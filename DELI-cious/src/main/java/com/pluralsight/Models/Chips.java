package com.pluralsight.Models;

// Chips.java

public class Chips extends Product {
    public Chips() {
        super("Chips", 1.50);
    }

    @Override
    public String getDescription() {
        return "Bag of chips";
    }
}
