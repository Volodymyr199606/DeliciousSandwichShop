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
    private String bankCardType;
    private String paymentCardType;
    private String maskedCardNumber;
    private String bankName;
    private List<String> sides;



    public Order() {
        products = new ArrayList<>();
        cashierName = generateRandomCashierName();
        orderDate = LocalDateTime.now();
        receiptNumber = generateRandomReceiptNumber();
        streetName = generateRandomStreetName();
        storeNumber = generateRandomStoreNumber();
        bankCardType = generateRandomBankCardType();
        paymentCardType = generateRandomPaymentCardType();
        maskedCardNumber = generateMaskedCardNumber();
        bankName = generateRandomBankName();
        sides = new ArrayList<>();


    }




    public List<Product> getProducts() {
        return products;
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    public void addSide(String side) {
        sides.add(side);
    }

    public List<String> getSides() {
        return sides;
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

    // Method to generate a random bank card type
    private String generateRandomBankCardType() {
        List<String> cardTypes = Arrays.asList("Bank of America", "Chase", "Wells Fargo", "Citibank", "US Bank");
        Random rand = new Random();
        return cardTypes.get(rand.nextInt(cardTypes.size()));
    }

    // Method to generate a random payment card type
    private String generateRandomPaymentCardType() {
        List<String> cardTypes = Arrays.asList("Visa", "Debit");
        Random rand = new Random();
        return cardTypes.get(rand.nextInt(cardTypes.size()));
    }

    // Method to generate a masked card number
    private String generateMaskedCardNumber() {
        Random rand = new Random();
        StringBuilder maskedNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            maskedNumber.append(rand.nextInt(10)); // Generates a random digit
        }
        return "**********" + maskedNumber.toString();


    }

    private String generateRandomBankName() {
        List<String> bankNames = Arrays.asList("Bank of America", "Chase", "Wells Fargo", "Citibank", "US Bank");
        Random rand = new Random();
        return bankNames.get(rand.nextInt(bankNames.size()));
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

            } else if (product instanceof Drink) {
                Drink drink = (Drink) product;
                details.append("Drink Size: ").append(drink.getDescription()).append(" - $").append(drink.getPrice()).append("\n");
            } else {
                details.append(product.getDescription()).append(" - $").append(product.getPrice()).append("\n");
            }
        }


        if (!sides.isEmpty()) {
            details.append("Sides: ");
            for (String side : sides) {
                details.append(side).append(", ");
            }
            details.setLength(details.length() - 2); // Remove trailing comma and space
            details.append("\n");
        }



        double totalCost = getTotalCost();
        double californiaTaxRate = 0.0825; // Example: 8.25% CA sales tax rate
        double tax = totalCost * californiaTaxRate;
        double totalWithTax = totalCost + tax;



        // Add subtotal and tax details
        details.append("----------------------------------------------------------------------------------------------------------\n");
        details.append("Subtotal: $").append(String.format("%.2f", totalCost)).append("\n");
        details.append("Tax (").append(String.format("%.2f", californiaTaxRate * 100)).append("%): $").append(String.format("%.2f", tax)).append("\n");
        details.append("----------------------------------------------------------------------------------------------------------\n");
        details.append("Total Cost: $").append(String.format("%.2f", totalWithTax)).append("\n");

        details.append("----------------------------------------------------------------------------------------------------------\n");
        details.append("Payment Method: ").append(paymentCardType).append("\n");
        details.append("Bank Name: ").append(bankName).append("\n");
        details.append("Card Number: ").append(maskedCardNumber).append("\n");
        details.append("----------------------------------------------------------------------------------------------------------\n");

        // Add closing message
        details.append("THANK YOU, PLEASE VISIT US AGAIN\n");
        return details.toString();
    }

    public static void main(String[] args) {
        Order order = new Order();

        BLT blt = new BLT();
        Chips chips = new Chips();

        order.addProduct(blt);
        order.addProduct(chips);



        order.addSide("French Fries");
        order.addSide("Onion Rings");

        System.out.println(order.getOrderDetails());
    }
}

