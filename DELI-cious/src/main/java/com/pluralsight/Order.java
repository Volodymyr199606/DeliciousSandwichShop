package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<String> drinks;
    private int chips;
    private double totalCost;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = 0;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void addSandwich(Sandwich sandwich) {
        this.sandwiches.add(sandwich);
    }

    public List<String> getDrinks() {
        return drinks;
    }

    public void addDrink(String drink) {
        this.drinks.add(drink);
    }

    public int getChips() {
        return chips;
    }

    public void addChips(int chips) {
        this.chips += chips;
    }

    public double getTotalCost() {
        // Calculate the total cost based on the sandwiches, drinks, and chips in the order
        // This will need to be updated as you add more functionality to the Sandwich and Topping classes
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}