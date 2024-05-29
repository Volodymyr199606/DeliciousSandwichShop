package com.pluralsight.Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Order {
    private List<Product> products;
    private String cashierName;
    private LocalDateTime orderDate;
    private int receiptNumber;
    private String streetName;
    private int storeNumber;

    public Order() {
        products = new ArrayList<>();
        cashierName = generateRandomCashierName();
        orderDate = LocalDateTime.now();
        receiptNumber = generateRandomReceiptNumber();
        streetName = generateRandomStreetName();
        storeNumber = generateRandomStoreNumber();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalCost() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    private int generateRandomReceiptNumber() {
        Random rand = new Random();
        return rand.nextInt(10000);
    }

    private String generateRandomStreetName() {
        List<String> streetNames = Arrays.asList("Maple St.", "Elm St.", "Oak St.", "Pine St.", "Cedar St.");
        Random rand = new Random();
        return streetNames.get(rand.nextInt(streetNames.size()));
    }

    private String generateRandomCashierName() {
        List<String> cashierNames = Arrays.asList("Alice", "Bob", "Charlie", "Daisy", "Edward", "John");
        Random rand = new Random();
        return cashierNames.get(rand.nextInt(cashierNames.size()));
    }

    private int generateRandomStoreNumber() {
        Random rand = new Random();
        return rand.nextInt(100);
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");

        details.append("----------------------------------------------------------------------------------------------------------\n");
        details.append("                                           Sandwich Shop\n");
        details.append("----------------------------------------------------------------------------------------------------------\n");
        details.append("                                         Order Receipt ").append(receiptNumber).append("\n");
        details.append("                                           Cashier: ").append(cashierName).append("\n");
        details.append("                                     Date: ").append(orderDate.format(formatter)).append("\n");
        details.append("                                         Street: ").append(streetName).append("\n");
        details.append("                                             State: CA\n");
        details.append("                                          Store Number: ").append(storeNumber).append("\n");
        details.append("----------------------------------------------------------------------------------------------------------\n");

        for (Product product : products) {
            if (product instanceof Sandwich) {
                Sandwich sandwich = (Sandwich) product;
                details.append("Sandwich Size: ").append(sandwich.getSize().getInches()).append("\" ($").append(sandwich.getSize().getPrice()).append(")\n");
                details.append("Bread Type: ").append(sandwich.getBreadType()).append("\n");

                if (!sandwich.getRegularToppings().isEmpty()) {
                    details.append("Regular Toppings: ");
                    for (RegularTopping topping : sandwich.getRegularToppings()) {
                        details.append(topping.getName()).append(", ");
                    }
                    details.setLength(details.length() - 2); // Remove trailing comma and space
                    details.append("\n");
                }

                if (!sandwich.getPremiumToppings().isEmpty()) {
                    details.append("Premium Toppings: ");
                    for (PremiumTopping topping : sandwich.getPremiumToppings()) {
                        details.append(topping.getName());
                        if (topping.isExtra()) {
                            details.append(" (extra)");
                        }
                        details.append(", ");
                    }
                    details.setLength(details.length() - 2); // Remove trailing comma and space
                    details.append("\n");
                }

                if (!sandwich.getSauces().isEmpty()) {
                    details.append("Sauces: ");
                    for (Sauce sauce : sandwich.getSauces()) {
                        details.append(sauce.getName()).append(", ");
                    }
                    details.setLength(details.length() - 2); // Remove trailing comma and space
                    details.append("\n");
                }


                details.append("Toasted: ").append(sandwich.isToasted() ? "Yes" : "No").append("\n");
            } else {
                if (product instanceof Drink) {
                    details.append("Drink Size: ").append(product.getDescription()).append(" - $").append(product.getPrice()).append("\n");
                } else {

                    details.append(product.getDescription()).append(" - $").append(product.getPrice()).append("\n");
                }
            }
        }

        // Calculate tax for California (hypothetical example)
        double totalCost = getTotalCost();
        double californiaTaxRate = 0.0825; // Example: 8.25% CA sales tax rate
        double tax = totalCost * californiaTaxRate;
        double totalWithTax = totalCost + tax;



        details.append("----------------------------------------------------------------------------------------------------------\n");
        details.append("Subtotal: $").append(String.format("%.2f", totalCost)).append("\n");
        details.append("Tax (").append(String.format("%.2f", californiaTaxRate * 100)).append("%): $").append(String.format("%.2f", tax)).append("\n");
        details.append("----------------------------------------------------------------------------------------------------------\n");
        details.append("Total Cost: $").append(String.format("%.2f", totalWithTax)).append("\n");
        details.append("----------------------------------------------------------------------------------------------------------\n");
        details.append("THANK YOU, PLEASE VISIT US AGAIN\n");

        return details.toString();
    }

    public static void main(String[] args) {
        Order order = new Order();

        BLT blt = new BLT();
        Chips chips = new Chips();

        order.addProduct(blt);
        order.addProduct(chips);

        System.out.println(order.getOrderDetails());
    }
}

