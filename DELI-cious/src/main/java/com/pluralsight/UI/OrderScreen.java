package com.pluralsight.UI;

import com.pluralsight.Models.*;
import com.pluralsight.Models.Subclasses.Sandwich;

import java.util.List;

public class OrderScreen {
    private List<Sandwich> sandwiches;
    private List<RegularTopping> toppings;
    private List<Sauce> sauces;
    private Order currentOrder;

    public OrderScreen(List<Sandwich> sandwiches, List<RegularTopping> toppings, List<Sauce> sauces) {
        this.sandwiches = sandwiches;
        this.toppings = toppings;
        this.sauces = sauces;
        this.currentOrder = new Order();
    }

    public void displayItems() {
        System.out.println("Available sandwiches:");
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich.getDescription());
        }

        System.out.println("\nAvailable toppings:");
        for (RegularTopping topping : toppings) {
            System.out.println(topping.getName());
        }

        System.out.println("\nAvailable sauces:");
        for (Sauce sauce : sauces) {
            System.out.println(sauce.getName());
        }
    }

    public void addItemToOrder(Sandwich sandwich, RegularTopping topping, Sauce sauce) {
        currentOrder.addProduct(sandwich);
        sandwich.addRegularTopping(topping);
        sandwich.addSauce(sauce);
    }
}