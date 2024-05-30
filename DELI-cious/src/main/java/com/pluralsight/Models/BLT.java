// BLT.java
package com.pluralsight.Models;

public class BLT extends Sandwich {
    public BLT() {
        super(new Size(8, 7.00), "White"); // Default size and price for the signature sandwich
        addPremiumTopping(new PremiumTopping("Bacon", false));
        addPremiumTopping(new PremiumTopping("Cheddar", false));
        addRegularTopping(new RegularTopping("Lettuce"));
        addRegularTopping(new RegularTopping("Tomato"));
        addSauce(new Sauce("Ranch"));
        setToasted(true); // Assume BLT is toasted by default
    }

    @Override
    public String getDescription() {
        return "BLT Sandwich: " + super.getDescription() + ", Ranch";
    }
}
