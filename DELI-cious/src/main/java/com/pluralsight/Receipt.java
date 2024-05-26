package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private Order order;

    public Receipt(Order order) {
        this.order = order;
    }

    public void generateReceipt() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        LocalDateTime now = LocalDateTime.now();
        String fileName = dtf.format(now) + ".txt";

        // Create the directory if it doesn't exist
        Path path = Paths.get("OrderReceipts");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.out.println("Failed to create directory 'OrderReceipts'");
                e.printStackTrace();
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("OrderReceipts/" + fileName))) {
            writer.write("Order Receipt\n");
            writer.write("Date: " + dtf.format(now) + "\n");
            writer.write("--------------------------------------------------\n");

            for (Sandwich sandwich : order.getSandwiches()) {
                writer.write("Sandwich: " + sandwich.getSize() + "\" " + sandwich.getBread() + "\n");
                writer.write("Toasted: " + (sandwich.isToasted() ? "Yes" : "No") + "\n");
                writer.write("Regular Toppings: " + sandwich.getRegularToppings() + "\n");
                writer.write("Premium Toppings: " + sandwich.getPremiumToppings() + "\n");
                writer.write("--------------------------------------------------\n");
            }

            writer.write("Drinks: " + order.getDrinks() + "\n");
            writer.write("Chips: " + order.getChips() + "\n");
            writer.write("--------------------------------------------------\n");
            writer.write("Total Cost: $" + order.getTotalCost() + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while generating the receipt.");
            e.printStackTrace();
        }
    }
}