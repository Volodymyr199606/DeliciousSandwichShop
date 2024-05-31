package com.pluralsight.Models.Subclasses;

// Chips.java

import com.pluralsight.Models.AbstractClass.Product;

public class Chips extends Product
{
    public Chips() {
        super("Chips", 1.50);
    }



    @Override
    public String getDescription() {
        return "Bag of chips";
    }
}
