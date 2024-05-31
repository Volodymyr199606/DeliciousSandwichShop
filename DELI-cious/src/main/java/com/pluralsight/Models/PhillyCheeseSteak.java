package com.pluralsight.Models;

import com.pluralsight.Models.Subclasses.Sandwich;

public class PhillyCheeseSteak extends Sandwich
{
    public PhillyCheeseSteak() {
        super(new Size(8, 7.00), "White"); // Default size and price for the signature sandwich
        addPremiumTopping(new PremiumTopping("Steak", false));
        addPremiumTopping(new PremiumTopping("American", false));
        addRegularTopping(new RegularTopping("Peppers"));
        addSauce(new Sauce("Mayo"));
        setToasted(true); // Assume Philly Cheese Steak is toasted by default
    }

    @Override
    public String getDescription() {
        return "Philly Cheese Steak Sandwich: " + super.getDescription() + ", Mayo";
    }
}