package com.pluralsight;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Arrays;




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

            // Calculate the number of spaces needed on each side
            int width = 100;
            String name = "Sandwich Shop";
            int spaces = (width - name.length()) / 2;

            // Create a string of spaces
            String padding = String.format("%" + spaces + "s", "");


            // Write the name centered
            writer.write(padding + name + padding + "\n");


            Random random = new Random();

            // Generate a random number
            int randomNumber = random.nextInt(10000);  // You can adjust the range as needed


            // Append the random number to the "Order Receipt" string
            String orderReceipt = "Order Receipt " + randomNumber;

            // Write the orderReceipt string to the receipt
            writer.write(orderReceipt + "\n");



            // Write the cashier name and date to the receipt
            writer.write("Cashier: " + order.getCashierName() + "\n");
            writer.write("Date: " + dtf.format(now) + "\n");

            // Generate a random street number between 1 and 1000
            int streetNumber = random.nextInt(1000) + 1;

            // Generate a random store number between 1 and 100
            int storeNumber = random.nextInt(100) + 1;

            // List of street names in California
            List<String> streets = Arrays.asList("Main St.", "Elm St.", "Oak St.", "Pine St.", "Maple St.");

            // Generate a random index between 0 and the size of the list
            int index = random.nextInt(streets.size());

            // Create the street and store strings
            String street = "Street: " + streets.get(index);

            String state = "State: CA";
            String store = "Store Number: " + storeNumber;


            // Write the street, state, and store to the receipt
            writer.write(street + "\n");
            writer.write(state + "\n");
            writer.write(store + "\n");
            writer.write("--------------------------------------------------\n");



            for (Sandwich sandwich : order.getSandwiches()) {
                String size = sandwich.getSize();
                String bread = sandwich.getBread(); // get the bread type


                // write size and bread type to receipt file
                writer.write("Sandwich Size: " + size + "\n");
                writer.write("Bread Type: " + bread + "\n");



                // write toppings to receipt file
                String toppings = String.join(", ", sandwich.getToppings());
                writer.write("Regular Toppings: " + toppings + "\n");




                // write premium toppings to receipt file
                List<String> premiumToppingsList = sandwich.getPremiumToppings();
                if (!premiumToppingsList.isEmpty()) {
                    String premiumToppings = String.join(", ", premiumToppingsList);
                    writer.write("Premium Toppings: " + premiumToppings + "\n");
                }



                List<String> meatsList = sandwich.getMeats();
                List<String> cheesesList = sandwich.getCheeses();


                if (!meatsList.isEmpty() || !cheesesList.isEmpty()) {
                    String meats = (meatsList.isEmpty()) ? "None" : String.join(", ", meatsList);
                    String cheeses = (cheesesList.isEmpty()) ? "None" : String.join(", ", cheesesList);

                    writer.write("Premium Toppings: Meats - " + meats + ", Cheeses - " + cheeses + "\n");
                }




                // write toasted option to receipt file
                if (sandwich.isToasted()) {
                    writer.write("Toasted: Yes\n");
                }

                //sauses to receipt file
                List<String> saucesList = sandwich.getSauces();
                if (!saucesList.isEmpty()) {
                    String sauces = String.join(", ", saucesList);
                    writer.write("Sauces: " + sauces + "\n");
                }


                // write sides to receipt file
                List<String> sidesList = sandwich.getSides();
                if (!sidesList.isEmpty()) {
                    String sides = String.join(", ", sidesList);
                    writer.write("Sides: " + sides + "\n");



                    // write extra toppings to receipt file
                    List<String> extraMeatsList = sandwich.getExtraMeats();
                    List<String> extraCheesesList = sandwich.getExtraCheeses();



                    if (!extraMeatsList.isEmpty() || !extraCheesesList.isEmpty()) {
                        StringBuilder extraMeats = new StringBuilder();
                        StringBuilder extraCheeses = new StringBuilder();

                        for (String meat : extraMeatsList) {
                            extraMeats.append("(Extra - ").append(meat).append(") ");
                        }

                        for (String cheese : extraCheesesList) {
                            extraCheeses.append("(Extra - ").append(cheese).append(") ");
                        }

                        writer.write("Extra Toppings: Meats - " + extraMeats.toString().trim() + ", Cheeses - " + extraCheeses.toString().trim() + "\n");
                    }

                }


            }


            List<String> drinksList = order.getDrinks();
            if (!drinksList.isEmpty()) {
                writer.write("Drinks: " + String.join(", ", drinksList) + "\n");
            }



            Map<String, Integer> chipsMap = order.getChips();
            for (Map.Entry<String, Integer> entry : chipsMap.entrySet()) {
                String chips = "Chips: " + entry.getKey();
                writer.write(chips + "\n");
            }




            writer.write("--------------------------------------------------\n");
            writer.write("Total Cost: $" + order.getTotalCost() + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred while generating the receipt.");
            e.printStackTrace();
        }



    }


}