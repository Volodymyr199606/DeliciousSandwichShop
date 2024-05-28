package com.pluralsight;
import java.util.*;

public class Order {
    private List<Sandwich> sandwiches;
    private List<String> drinks;
    private Map<String, Integer> chips;
    private double totalCost;
    private List<String> items = new ArrayList<>();
    private String cashierName;




    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new HashMap<>();
        this.cashierName = generateRandomCashierName();

    }




    public void addSandwich(Sandwich sandwich) {
        this.sandwiches.add(sandwich);
        items.add("Sandwich: " + sandwich.toString());
        items.add(sandwich.toString());

    }

    public void addDrink(String drink) {
        this.drinks.add(drink);
        this.totalCost += 2.0;
        items.add("Drink: " + drink);// assuming a fixed cost for drinks
    }

    public void addChips(String chips) {
        this.chips.put(chips, 1);
    }


    public void calculateTotalCost() {
        for (Sandwich sandwich : sandwiches) {
            this.totalCost += sandwich.calculateCost();
        }
    }

    public void generateReceipt() {
        Receipt receipt = new Receipt(this);
        receipt.generateReceipt();
    }


    // existing getters and setters...

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<String> getDrinks() {
        return drinks;
    }

    public Map<String, Integer> getChips() {
        return chips;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public List<String> getItems() {
        return items;
    }

    public String getCashierName() {
        return cashierName;
    }

    private String generateRandomCashierName() {
        String[] names = {"John", "Jane", "Bob", "Alice", "Charlie", "Diana"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }



}
