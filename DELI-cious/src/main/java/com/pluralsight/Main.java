package com.pluralsight;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order();
        Receipt receipt = new Receipt(order);
        System.out.println("");
        System.out.println("                                                     *****  Welcome to our Sandwich Shop! *****");
        System.out.println("");

        boolean isFirstOrder = true;


        while (true) {
            if (isFirstOrder) {

                System.out.println("Do you want to add a sandwich to your order? (yes/no)");
                isFirstOrder = false;



            } else {
                System.out.println("Do you want to add another sandwich to your order? (yes/no)");
            }

            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }



            {
            System.out.println("Choose the size of your sandwich (Small/Medium/Large):");
            String size = scanner.nextLine();

            System.out.println("Choose the type of bread (White/Wheat/Rye/Wrap):");
            String bread = scanner.nextLine();

            Sandwich sandwich = new Sandwich(size, bread);




            System.out.println("Choose your regular toppings (Lettuce/Tomato/Onion/Pepper/Jalepenos/Cucumbers/Pickles):");
            String regularToppings = scanner.nextLine();
            sandwich.setRegularToppings(regularToppings.split(","));




            System.out.println("Do you want to add premium toppings? (yes/no)");
            String addPremium = scanner.nextLine();
            if (addPremium.equalsIgnoreCase("yes")) {
                System.out.println("Choose your meats (Steak/Ham/Salami/Roast Beef/Chicken/Bacon):");
                String meats = scanner.nextLine();
                for (String meat : meats.split(",")) {
                    sandwich.addMeat(meat.trim());
                }

                System.out.println("Choose your cheeses (American/Provolone/Cheddar/Swiss):");
                String cheeses = scanner.nextLine();
                for (String cheese : cheeses.split(",")) {
                    sandwich.addCheese(cheese.trim());
                }


                System.out.println("Do you want your sandwich toasted? (yes/no)");
                String toasted = scanner.nextLine();
                sandwich.setToasted(toasted.equalsIgnoreCase("yes"));




                System.out.println("Do you want to add sauces? (yes/no)");
                String addSauces = scanner.nextLine();
                if (addSauces.equalsIgnoreCase("yes")) {
                    System.out.println("Choose your sauces (Mayo/Mustard/Ketchup/Ranch/Thousand Islands/Vinaigrette):");
                    String sauces = scanner.nextLine();
                    for (String sauce : sauces.split(",")) {
                        sandwich.addSauce(sauce.trim());
                    }
                }

                System.out.println("Do you want to add sides? (yes/no)");
                String addSides = scanner.nextLine();
                if (addSides.equalsIgnoreCase("yes")) {
                    System.out.println("Choose your sides (beans/aujus/):");
                    String sides = scanner.nextLine();
                    for (String side : sides.split(",")) {
                        sandwich.addSide(side.trim());
                    }
                }


            }

            System.out.println("Do you want to add extra toppings? (yes/no)");
            String addExtra = scanner.nextLine();
            if (addExtra.equalsIgnoreCase("yes")) {
                System.out.println("Choose your extra meats (Steak/Ham/Salami/Roast Beef/Chicken/Bacon):");
                String extraMeats = scanner.nextLine();
                for (String meat : extraMeats.split(",")) {
                    sandwich.addMeat(meat.trim());
                }

                System.out.println("Choose your extra cheeses (american/provolone/cheddar/swiss):");
                String extraCheeses = scanner.nextLine();
                for (String cheese : extraCheeses.split(",")) {
                    sandwich.addCheese(cheese.trim());
                }
            }


            // Add meats, cheeses, toppings, sauces, sides, extra meat, and extra cheese to the sandwich
            // ...

            order.addSandwich(sandwich);
        }


        System.out.println("Do you want to add drinks to your order? (yes/no)");
        String addDrinks = scanner.nextLine();
        if (addDrinks.equalsIgnoreCase("yes")) {
            System.out.println("Choose your drink (CocaCola/Pepsi/Fanta/Sprite):");
            String drink = scanner.nextLine();
            order.addDrink(drink.trim());
        }

        System.out.println("Do you want to add chips to your order? (yes/no)");
        String addChips = scanner.nextLine();
        if (addChips.equalsIgnoreCase("yes")) {
            System.out.println("Choose your chips (Lays/Pringles/Kettle):");
            String chips = scanner.nextLine();
            order.addChips(chips);
        }
    }



    // Add drinks and chips to the order
        // ...

        order.calculateTotalCost();
        order.generateReceipt();



        System.out.println("Thank you for your order!");
    }
}