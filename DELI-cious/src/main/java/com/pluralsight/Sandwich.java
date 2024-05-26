package com.pluralsight;

import java.util.List;

public class Sandwich {
    private String size;
    private String bread;
    private boolean toasted;
    private List<Topping> regularToppings;
    private List<Topping> premiumToppings;

    public Sandwich(String size, String bread, boolean toasted, List<Topping> regularToppings, List<Topping> premiumToppings) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
        this.regularToppings = regularToppings;
        this.premiumToppings = premiumToppings;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public List<Topping> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(List<Topping> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public List<Topping> getPremiumToppings() {
        return premiumToppings;
    }

    public void setPremiumToppings(List<Topping> premiumToppings) {
        this.premiumToppings = premiumToppings;
    }
}