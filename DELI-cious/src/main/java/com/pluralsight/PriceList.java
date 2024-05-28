package com.pluralsight;

public class PriceList {
    private static final double SMALL_SANDWICH_PRICE = 5.50;
    private static final double MEDIUM_SANDWICH_PRICE = 7.00;
    private static final double LARGE_SANDWICH_PRICE = 8.50;

    private static final double SMALL_EXTRA_MEAT_PRICE = 0.50;
    private static final double MEDIUM_EXTRA_MEAT_PRICE = 1.00;
    private static final double LARGE_EXTRA_MEAT_PRICE = 1.50;

    private static final double SMALL_EXTRA_CHEESE_PRICE = 0.30;
    private static final double MEDIUM_EXTRA_CHEESE_PRICE = 0.60;
    private static final double LARGE_EXTRA_CHEESE_PRICE = 0.90;

    private static final double SMALL_DRINK_PRICE = 2.00;
    private static final double MEDIUM_DRINK_PRICE = 2.50;
    private static final double LARGE_DRINK_PRICE = 3.00;

    private static final double CHIPS_PRICE = 1.50;

    // Add more constants for the prices of other components and products...

    public static double getSandwichPrice(String size) {
        switch (size.toLowerCase()) {
            case "small":
                return SMALL_SANDWICH_PRICE;
            case "medium":
                return MEDIUM_SANDWICH_PRICE;
            case "large":
                return LARGE_SANDWICH_PRICE;
            default:
                throw new IllegalArgumentException("Invalid sandwich size: " + size);
        }
    }

    // Add more methods to get the prices of other components and products...
}