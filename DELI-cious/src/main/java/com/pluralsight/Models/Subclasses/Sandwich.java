package com.pluralsight.Models.Subclasses;

import com.pluralsight.Models.*;
import com.pluralsight.Models.AbstractClass.Product;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Product
{
    private Size size;
    private String breadType;
    private List<RegularTopping> regularToppings = new ArrayList<>();
    private List<PremiumTopping> premiumToppings = new ArrayList<>();
    private List<Sauce> sauces = new ArrayList<>();
    private List<Side> sides = new ArrayList<>();


    private boolean toasted;

    public Sandwich(Size size, String breadType) {
        super("Sandwich", size.getPrice());
        this.size = size;
        this.breadType = breadType;
    }

    public void addSauce(Sauce sauce) {
        sauces.add(sauce);
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    public List<Side> getSides() {
        return sides;
    }


    public void addRegularTopping(RegularTopping topping) {
        regularToppings.add(topping);
    }

    public void addPremiumTopping(PremiumTopping topping) {
        premiumToppings.add(topping);
        price += topping.getCost(size.getInches());
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }


    public List<RegularTopping> getRegularToppings() {
        return regularToppings;
    }

    public List<PremiumTopping> getPremiumToppings() {
        return premiumToppings;
    }

    public List<Sauce> getSauces() {
        return sauces;
    }



    public boolean isToasted() {
        return toasted;
    }

    public String getBreadType() {
        return breadType;
    }

    public Size getSize() {
        return size;
    }



    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append("Size: ").append(size.getInches()).append("\"");
        description.append(", Bread: ").append(breadType);

        if (!regularToppings.isEmpty()) {
            description.append(", Regular Toppings: ");
            for (RegularTopping topping : regularToppings) {
                description.append(topping.getName()).append(", ");
            }
            // Remove the trailing comma and space
            description.setLength(description.length() - 2);
        }

        if (!premiumToppings.isEmpty()) {
            description.append(", Premium Toppings: ");
            for (PremiumTopping topping : premiumToppings) {
                description.append(topping.getName());
                if (topping.isExtra()) {
                    description.append(" (extra)");
                }
                description.append(", ");
            }
            // Remove the trailing comma and space
            description.setLength(description.length() - 2);
        }

        if (!sauces.isEmpty()) {
            description.append(", Sauces: ");
            for (Sauce sauce : sauces) {
                description.append(sauce.getName()).append(", ");
            }
            // Remove the trailing comma and space
            description.setLength(description.length() - 2);
        }

        if (!sides.isEmpty()) {
            description.append(", Sides: ");
            for (Side side : sides) {
                description.append(side.getDescription()).append(", ");
            }
            // Remove the trailing comma and space
            description.setLength(description.length() - 2);
        }



        description.append(", Toasted: ").append(toasted ? "Yes" : "No");
        return description.toString();
    }


}
