package com.pluralsight.UI;

import com.pluralsight.Models.Chips;
import com.pluralsight.Models.Drink;
import com.pluralsight.Models.Order;
import com.pluralsight.Models.Sandwich;
import com.pluralsight.Service.OrderService;
import com.pluralsight.Models.Size;
import com.pluralsight.Models.PremiumTopping;
import com.pluralsight.Models.RegularTopping;
import com.pluralsight.Models.BLT;
import com.pluralsight.Models.PhillyCheeseSteak;
import com.pluralsight.Models.Sauce;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    private static final double PRICE_4_INCH = 5.50;
    private static final double PRICE_8_INCH = 7.00;
    private static final double PRICE_12_INCH = 8.50;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println();
            System.out.println("Home Screen:");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            int choice = getIntInput("Enter your choice:");

            if (choice == 1) {
                createNewOrder();
            } else if (choice == 0) {
                break;
            }
        }
    }

    private static void createNewOrder() {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\nOrder Screen:");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            int choice = getIntInput("Enter your choice:");

            switch (choice) {
                case 1:
                    order.addProduct(createSandwich());
                    break;
                case 2:
                    order.addProduct(createDrink());
                    break;
                case 3:
                    order.addProduct(new Chips());
                    break;
                case 4:
                    checkout(order);
                    ordering = false;
                    break;
                case 0:
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }




    private static Sandwich createSandwich() {
        System.out.println("\nSelect Sandwich Type:");
        System.out.println("1) Custom Sandwich");
        System.out.println("2) BLT");
        System.out.println("3) Philly Cheese Steak");

        int sandwichChoice = getIntInput("Enter your choice:");
        Sandwich sandwich;
        switch (sandwichChoice) {
            case 1:
                Size size = getSizeChoice();
                String breadType = getBreadChoice();
                sandwich = new Sandwich(size, breadType);
                addToppings(sandwich);
                boolean toasted = getYesNoInput("Toasted? (yes/no)");
                sandwich.setToasted(toasted);
                break;
            case 2:
                sandwich = new BLT();
                break;
            case 3:
                sandwich = new PhillyCheeseSteak();
                break;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
        return sandwich;
    }

    private static Size getSizeChoice() {
        System.out.println("\nSelect Size:");
        System.out.println("1) 4\" ($5.50)");
        System.out.println("2) 8\" ($7.00)");
        System.out.println("3) 12\" ($8.50)");

        int sizeChoice = getIntInput("Enter your choice:");
        return switch (sizeChoice) {
            case 1 -> new Size(4, PRICE_4_INCH);
            case 2 -> new Size(8, PRICE_8_INCH);
            case 3 -> new Size(12, PRICE_12_INCH);
            default -> throw new IllegalArgumentException("Invalid choice");
        };
    }

    private static String getBreadChoice() {
        System.out.println("\nSelect Bread Type:");
        System.out.println("1) Wheat");
        System.out.println("2) White");
        System.out.println("3) Rye");

        int breadChoice = getIntInput("Enter your choice:");
        return switch (breadChoice) {
            case 1 -> "Wheat";
            case 2 -> "White";
            case 3 -> "Rye";
            default -> throw new IllegalArgumentException("Invalid choice");
        };
    }

    private static void addToppings(Sandwich sandwich) {
        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println("\nAdd Toppings:");
            System.out.println("1) Regular Toppings");
            System.out.println("2) Premium Toppings");
            System.out.println("3) Sauces");
            System.out.println("0) Done");

            int toppingChoice = getIntInput("Enter your choice:");

            switch (toppingChoice) {
                case 1:
                    addRegularTopping(sandwich);
                    break;
                case 2:
                    addPremiumTopping(sandwich);
                    break;
                case 3:
                    addSauce(sandwich);
                    break;
                case 0:
                    addingToppings = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }


    private static void addSauce(Sandwich sandwich) {
        System.out.println("\nSelect Sauce:");
        System.out.println("1) Mayo");
        System.out.println("2) Mustard");
        System.out.println("3) Ketchup");
        System.out.println("4) BBQ");
        System.out.println("5) Ranch");
        System.out.println("6) Chipotle");

        int sauceChoice = getIntInput("Enter your choice:");
        String sauce = switch (sauceChoice) {
            case 1 -> "Mayo";
            case 2 -> "Mustard";
            case 3 -> "Ketchup";
            case 4 -> "BBQ";
            case 5 -> "Ranch";
            case 6 -> "Chipotle";
            default -> throw new IllegalArgumentException("Invalid choice");
        };

        sandwich.addSauce(new Sauce(sauce));
    }

    private static void addRegularTopping(Sandwich sandwich) {
        System.out.println("\nSelect Regular Topping:");
        System.out.println("1) Lettuce");
        System.out.println("2) Tomato");
        System.out.println("3) Onion");
        System.out.println("4) Green Pepper");
        System.out.println("5) Pickles");
        System.out.println("6) Cucumber");
        System.out.println("7) Jalapeno");

        int toppingChoice = getIntInput("Enter your choice:");
        String topping = switch (toppingChoice) {
            case 1 -> "Lettuce";
            case 2 -> "Tomato";
            case 3 -> "Onion";
            case 4 -> "Green Pepper";
            case 5 -> "Pickles";
            case 6 -> "Cucumber";
            case 7 -> "Jalapeno";
            default -> throw new IllegalArgumentException("Invalid choice");
        };

        sandwich.addRegularTopping(new RegularTopping(topping));
    }

    private static void addPremiumTopping(Sandwich sandwich) {
        System.out.println("\nSelect Premium Topping:");
        System.out.println("1) Meat");
        System.out.println("2) Cheese");

        int premiumChoice = getIntInput("Enter your choice:");

        switch (premiumChoice) {
            case 1:
                addMeat(sandwich);
                break;
            case 2:
                addCheese(sandwich);
                break;
            default:
                throw new IllegalArgumentException("Invalid choice");

        }


    }

    private static void addMeat(Sandwich sandwich) {
        System.out.println("\nSelect Meat:");
        System.out.println("1) Steak");
        System.out.println("2) Ham");
        System.out.println("3) Salami");
        System.out.println("4) Roast Beef");
        System.out.println("5) Chicken");
        System.out.println("6) Bacon");

        int meatChoice = getIntInput("Enter your choice:");
        String meat = switch (meatChoice) {
            case 1 -> "Steak";
            case 2 -> "Ham";
            case 3 -> "Salami";
            case 4 -> "Roast Beef";
            case 5 -> "Chicken";
            case 6 -> "Bacon";
            default -> throw new IllegalArgumentException("Invalid choice");
        };

        boolean extra = getYesNoInput("Extra meat? (yes/no)");

        sandwich.addPremiumTopping(new PremiumTopping(meat, extra));
    }

    private static void addCheese(Sandwich sandwich) {
        System.out.println("\nSelect Cheese:");
        System.out.println("1) American");
        System.out.println("2) Provolone");
        System.out.println("3) Cheddar");
        System.out.println("4) Swiss");

        int cheeseChoice = getIntInput("Enter your choice:");
        String cheese = switch (cheeseChoice) {
            case 1 -> "American";
            case 2 -> "Provolone";
            case 3 -> "Cheddar";
            case 4 -> "Swiss";
            default -> throw new IllegalArgumentException("Invalid choice");
        };

        boolean extra = getYesNoInput("Extra cheese? (yes/no)");

        sandwich.addPremiumTopping(new PremiumTopping(cheese, extra));
    }

    private static Drink createDrink() {
        System.out.println("\nSelect Drink Size:");
        System.out.println("1) Small ($2.00)");
        System.out.println("2) Medium ($2.50)");
        System.out.println("3) Large ($3.00)");

        int sizeChoice = getIntInput("Enter your choice:");
        String size = switch (sizeChoice) {
            case 1 -> "Small";
            case 2 -> "Medium";
            case 3 -> "Large";
            default -> throw new IllegalArgumentException("Invalid choice");
        };

        return new Drink(size);
    }

    private static void checkout(Order order) {
        System.out.println("\nOrder Summary:");
        System.out.println(order.getOrderDetails());
        System.out.println("Saving order to file...");
        try {
            OrderService.saveOrderToFile(order);
            System.out.println("Order saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving order: " + e.getMessage());
        }
    }

    private static int getIntInput(String prompt) {
        System.out.print(prompt + " ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. " + prompt + " ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static boolean getYesNoInput(String prompt) {
        System.out.print(prompt + " ");
        String input = scanner.next();
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y");
    }
}

