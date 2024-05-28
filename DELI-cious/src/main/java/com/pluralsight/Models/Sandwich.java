package com.pluralsight.Models;
import com.pluralsight.PriceList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sandwich {
    private String size;
    private String bread;
    private String breadType;
    private List<String> meats;
    private List<String> cheeses;
    private List<String> regularToppings;
    private List<String> premiumToppings;
    private List<String> sauces; // added sauces field
    private List<String> sides;
    private List<String> extraMeats;
    private List<String> extraCheeses;
    private List<String> toppings;


    private boolean extraMeat;
    private boolean extraCheese;
    private boolean toasted;
    private boolean isToasted;






    public Sandwich(String size, String bread) {
        this.size = size;
        this.bread = bread;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
        this.extraMeat = false;
        this.extraCheese = false;
        this.toasted = false;
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
        this.extraMeats = new ArrayList<>();
        this.extraCheeses = new ArrayList<>();


    }

    public void setRegularToppings(String[] toppings) {
        this.regularToppings = Arrays.asList(toppings);
    }

    public boolean isToasted() {
        return toasted;
    }
    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }
    public List<String> getPremiumToppings() {
        return premiumToppings;
    }
    public void addPremiumTopping(String topping) {
        this.premiumToppings.add(topping);
    }


    // existing getters and setters...



    public List<String> getSides() {
        return sides;
    }


    public void addMeat(String meat) {
        this.meats.add(meat);
    }

    public void addCheese(String cheese) {
        this.cheeses.add(cheese);
    }

    public void addTopping(String topping) {
        this.regularToppings.add(topping);
    }

    public void addSauce(String sauce) {
        this.sauces.add(sauce);
    }

    public void addSide(String side) {
        this.sides.add(side);
    }
    public String getSize() {
        return this.size;
    }

    public String getBread() {
        return bread;
    }

    public List<String> getRegularToppings() {
        return regularToppings;
    }


    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public double calculateCost() {
        double cost = PriceList.getSandwichPrice(size);

        // Add costs for extra meat, cheese, and other components...

        return cost;
    }

    public List<String> getToppings() {
        if (this.regularToppings == null) {
            this.regularToppings = new ArrayList<>();
        }
        return this.regularToppings;
    }
    public List<String> getMeats() {
        return this.meats;
    }

    public List<String> getCheeses() {
        return this.cheeses;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public List<String> getExtraMeats() {
        return this.extraMeats;
    }

    public List<String> getExtraCheeses() {
        return this.extraCheeses;
    }
    public void addExtraMeat(String meat) {
        this.extraMeats.add(meat);
    }
    public void addExtraCheese(String cheese) {
        this.extraCheeses.add(cheese);
    }



}