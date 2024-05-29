package com.pluralsight.Models;

public class PremiumTopping {
    private String name;
    private boolean isExtra;

    public PremiumTopping(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public double getCost(int size) {
        double baseCost;
        if (name.equals("Steak") || name.equals("Ham") || name.equals("Salami") || name.equals("Roast Beef") || name.equals("Chicken") || name.equals("Bacon")) {
            // Meat
            baseCost = switch (size) {
                case 4 -> 1.00;
                case 8 -> 2.00;
                case 12 -> 3.00;
                default -> throw new IllegalArgumentException("Invalid size");
            };

        } else if (name.equals("American") || name.equals("Provolone") || name.equals("Cheddar") || name.equals("Swiss")) {
            // Cheese
            baseCost = switch (size) {
                case 4 -> 0.75;
                case 8 -> 1.50;
                case 12 -> 2.25;
                default -> throw new IllegalArgumentException("Invalid size");
            };


        } else {
            throw new IllegalArgumentException("Unknown topping: " + name);
        }


        // Add extra cost if the topping is marked as extra
        if (isExtra) {
            if (name.equals("American") || name.equals("Provolone") || name.equals("Cheddar") || name.equals("Swiss")) {
                // Extra cheese pricing
                baseCost += switch (size) {
                    case 4 -> 0.30;
                    case 8 -> 0.60;
                    case 12 -> 0.90;
                    default -> throw new IllegalArgumentException("Invalid size");
                };
            } else {
                // Extra meat pricing
                baseCost += switch (size) {
                    case 4 -> 0.50;
                    case 8 -> 1.00;
                    case 12 -> 1.50;
                    default -> throw new IllegalArgumentException("Invalid size");
                };
            }
        }
        return baseCost;
    }
}
