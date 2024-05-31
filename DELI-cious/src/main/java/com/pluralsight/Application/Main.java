package com.pluralsight.Application;

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

        int terminalWidth = 220;
        String ANSI_RESET = "\u001B[0m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_LIGHT_BLUE = "\u001B[38;5;39m";
        String ANSI_LIGHT_ORANGE = "\u001B[38;5;208m";


        while (true) {
            System.out.println();
            System.out.println();
            System.out.println(String.format("%" + (terminalWidth + "WELCOME TO THE SANDWICH SHOP!".length()) / 2 + "s", ANSI_CYAN + "WELCOME TO THE SANDWICH SHOP!" + ANSI_RESET));
            System.out.println();
            System.out.println();
            System.out.println(String.format("%" + (terminalWidth + "Home Screen:".length()) / 2 + "s", ANSI_YELLOW + "HOME SCREEN" + ANSI_RESET));
            System.out.println();
            System.out.println();
            System.out.println(ANSI_GREEN + "1) New Order" + ANSI_RESET);
            System.out.println(ANSI_LIGHT_ORANGE + "0) Exit" + ANSI_RESET);

            while (true) {
                int choice = getIntInput(ANSI_LIGHT_BLUE + "Enter your choice:" + ANSI_RESET);
                if (choice == 1) {
                    createNewOrder();
                    break;
                } else if (choice == 0) {
                    System.out.println();
                    System.out.println("\u001B[32m" + "THANK YOU, PLEASE VISIT US AGAIN" + "\u001B[0m");
                    return;
                } else {
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1 for New Order or 0 for Exit." + "\u001B[0m");                }
            }
        }
    }


    private static void createNewOrder()
    {
        int terminalWidth = 222;
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_LIGHT_BLUE = "\u001B[38;5;39m";
        String ANSI_LIGHT_YELLOW = "\u001B[38;5;226m";
        String ANSI_LIGHT_ORANGE = "\u001B[38;5;208m";


        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println(String.format("%" + (terminalWidth + "ORDER SCREEN".length()) / 2 + "s", ANSI_GREEN + "ORDER SCREEN" + ANSI_RESET));
            System.out.println();
            System.out.println();
            System.out.println(ANSI_LIGHT_ORANGE + "1) Add Sandwich" + ANSI_RESET);
            System.out.println(ANSI_LIGHT_BLUE + "2) Add Drink" + ANSI_RESET);
            System.out.println(ANSI_LIGHT_YELLOW + "3) Add Chips" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "4) Checkout" + ANSI_RESET);
            System.out.println(ANSI_RED + "0) Cancel Order" + ANSI_RESET);


            while (true) {
                int choice = getIntInput(ANSI_LIGHT_BLUE + "Enter your choice:" + ANSI_RESET);

                if (choice == 1) {
                    order.addProduct(createSandwich(order));
                    break;
                } else if (choice == 2) {
                    order.addProduct(createDrink());
                    break;
                } else if (choice == 3) {
                    order.addProduct(new Chips());
                    break;
                } else if (choice == 4) {
                    checkout(order);
                    ordering = false;
                    break;
                } else if (choice == 0) {
                    ordering = false;
                    break;
                } else {
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1) Add Sandwich, 2) Add Drink, 3) Add Chips, 4) Checkout, or 0) Cancel Order." + "\u001B[0m");                }
            }
        }
    }




    private static Sandwich createSandwich(Order order) {

        int terminalWidth = 220;

        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_LIGHT_BLUE = "\u001B[38;5;39m";
        String ANSI_LIGHT_YELLOW = "\u001B[38;5;226m";
        String ANSI_LIGHT_ORANGE = "\u001B[38;5;208m";
        String ANSI_BRONZE = "\u001B[38;5;180m";

        Sandwich sandwich;
        while (true) {
            System.out.println(String.format("%" + (terminalWidth + (ANSI_BRONZE + "SANDWICH TYPE SELECTION" + ANSI_RESET).length()) / 2 + "s", ANSI_BRONZE + "SANDWICH TYPE SELECTION" + ANSI_RESET));
            System.out.println(ANSI_LIGHT_ORANGE+ "\nSelect Sandwich Type:" + ANSI_RESET);
            System.out.println(ANSI_LIGHT_BLUE + "1) Custom Sandwich" + ANSI_RESET);
            System.out.println(ANSI_LIGHT_YELLOW + "2) BLT" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "3) Philly Cheese Steak" + ANSI_RESET);

            int sandwichChoice = getIntInput(ANSI_GREEN +"Enter your choice:" + ANSI_RESET);

            switch (sandwichChoice) {
                case 1:
                    Size size = getSizeChoice();
                    String breadType = getBreadChoice();
                    sandwich = new Sandwich(size, breadType);
                    addToppings(sandwich,order);
                    boolean toasted = getYesNoInput(ANSI_BRONZE + "Do you want Toasted? (yes/no)" + ANSI_RESET);
                    sandwich.setToasted(toasted);
                    break;
                case 2:
                    sandwich = new BLT();
                    break;
                case 3:
                    sandwich = new PhillyCheeseSteak();
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1) Custom Sandwich, 2) BLT, or 3) Philly Cheese Steak." + "\u001B[0m");                    continue;
            }
            break;
        }
        return sandwich;
    }




    private static Size getSizeChoice() {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_LIGHT_BLUE = "\u001B[38;5;39m";
        String ANSI_LIGHT_YELLOW = "\u001B[38;5;226m";



        Size size;
        while (true) {
            System.out.println(ANSI_LIGHT_YELLOW + "\nSelect Size:" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "1) 4 Size ($5.50)" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "2) 8 Size ($7.00)" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "3) 12 Size ($8.50)" + ANSI_RESET);

            int sizeChoice = getIntInput(ANSI_LIGHT_BLUE +"Enter your choice:" + ANSI_RESET);
            switch (sizeChoice) {
                case 1:
                    size = new Size(4, PRICE_4_INCH);
                    break;
                case 2:
                    size = new Size(8, PRICE_8_INCH);
                    break;
                case 3:
                    size = new Size(12, PRICE_12_INCH);
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1) for 4 Inch Size, 2) for 8 Inch Size, or 3) for 12 Inch Size." + "\u001B[0m");                    continue;
            }
            break;
        }
        return size;
    }

    private static String getBreadChoice() {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_LIGHT_YELLOW = "\u001B[38;5;226m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_LIGHT_BROWN = "\u001B[38;5;130m";


        String breadType;
        while (true) {
            System.out.println(ANSI_CYAN + "\nSelect Bread Type:" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "1) Wheat" + ANSI_RESET);
            System.out.println("2) White");
            System.out.println(ANSI_LIGHT_BROWN + "3) Rye" + ANSI_RESET);

            int breadChoice = getIntInput(ANSI_LIGHT_YELLOW +"Enter your choice:" + ANSI_RESET);
            switch (breadChoice) {
                case 1:
                    breadType = "Wheat";
                    break;
                case 2:
                    breadType = "White";
                    break;
                case 3:
                    breadType = "Rye";
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1) Wheat, 2) White, or 3) Rye." + "\u001B[0m");                    continue;
            }
            break;
        }
        return breadType;
    }
    private static void addToppings(Sandwich sandwich, Order order) {


        int terminalWidth = 215;

        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_LIGHT_BLUE = "\u001B[38;5;39m";
        String ANSI_LIGHT_ORANGE = "\u001B[38;5;208m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_LIGHT_CYAN = "\u001B[38;5;45m";


        boolean addingToppings = true;
        while (addingToppings) {

            System.out.println(String.format("%" + (terminalWidth + (ANSI_GREEN + "TOPPINGS SELECTION" + ANSI_RESET).length()) / 2 + "s", ANSI_GREEN + "TOPPINGS SELECTION" + ANSI_RESET));
            System.out.println();
            System.out.println(ANSI_GREEN + "\nAdd Toppings:" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "1) Regular Toppings" + ANSI_RESET);
            System.out.println(ANSI_LIGHT_CYAN + "2) Premium Toppings" + ANSI_RESET);
            System.out.println(ANSI_RED + "3) Sauces" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "4) Sides" + ANSI_RESET);
            System.out.println(ANSI_LIGHT_BLUE + "0) Done Adding Toppings" + ANSI_RESET);

            int toppingChoice = getIntInput(ANSI_LIGHT_ORANGE +"Enter your choice:" + ANSI_RESET);

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
                case 4:
                    addSides(order);
                    break;
                case 0:
                    addingToppings = false;
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Try again." + "\u001B[0m");
            }
        }
    }

    private static void addSides(Order order) {


        int terminalWidth = 215;

        String ANSI_RESET = "\u001B[0m";
        String ANSI_LIGHT_ORANGE = "\u001B[38;5;208m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RED = "\u001B[31m";


        while (true) {
            System.out.println(String.format("%" + (terminalWidth + (ANSI_YELLOW + "SIDES TYPE SELECTION" + ANSI_RESET).length()) / 2 + "s", ANSI_YELLOW + "SIDES TYPE SELECTION" + ANSI_RESET));
            System.out.println();
            System.out.println(ANSI_LIGHT_ORANGE + "\nSelect Side:" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "1) Au Jus" + ANSI_RESET);
            System.out.println(ANSI_RED + "2) Sauce" + ANSI_RESET);

            int sideChoice = getIntInput(ANSI_GREEN + "Enter your choice:" + ANSI_RESET);
            String side;
            switch (sideChoice) {
                case 1:
                    side = "aujus";
                    break;
                case 2:
                    side = "sauce";
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1) Au Jus or 2) Sauce." + "\u001B[0m");                    continue;
            }
            order.addSide(side);
            break;
        }
    }



    private static String getSideDescription(int sideChoice) {
        return switch (sideChoice) {
            case 1 -> "aujus";
            case 2 -> "sauce";
            default -> throw new IllegalArgumentException("Invalid choice");
        };
    }




    private static void addSauce(Sandwich sandwich) {
        int terminalWidth = 215;


        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_LIGHT_BROWN = "\u001B[38;5;130m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_CYAN = "\u001B[36m";

        while (true) {
            System.out.println(ANSI_CYAN + "\nSelect Sauce:" + ANSI_RESET);
            System.out.println("1) Mayo");
            System.out.println(ANSI_YELLOW + "2) Mustard" + ANSI_RESET);
            System.out.println(ANSI_RED + "3) Ketchup" + ANSI_RESET);
            System.out.println(ANSI_LIGHT_BROWN + "4) BBQ" + ANSI_RESET);
            System.out.println("5) Ranch");
            System.out.println(ANSI_YELLOW + "6) Chipotle" + ANSI_RESET);

            int sauceChoice = getIntInput(ANSI_CYAN + "Enter your choice:" + ANSI_RESET);
            String sauce;
            switch (sauceChoice) {
                case 1:
                    sauce = "Mayo";
                    break;
                case 2:
                    sauce = "Mustard";
                    break;
                case 3:
                    sauce = "Ketchup";
                    break;
                case 4:
                    sauce = "BBQ";
                    break;
                case 5:
                    sauce = "Ranch";
                    break;
                case 6:
                    sauce = "Chipotle";
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1) Mayo, 2) Mustard, 3) Ketchup, 4) BBQ, 5) Ranch, or 6) Chipotle." + "\u001B[0m");                    continue;
            }
            sandwich.addSauce(new Sauce(sauce));
            break;
        }
    }

    private static void addRegularTopping(Sandwich sandwich) {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_BLUE = "\u001B[34m";


        while (true) {
            System.out.println(ANSI_BLUE + "\nSelect Regular Topping:" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "1) Lettuce" + ANSI_RESET);
            System.out.println(ANSI_RED + "2) Tomato" + ANSI_RESET);
            System.out.println("3) Onion");
            System.out.println(ANSI_GREEN + "4) Green Pepper" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "5) Pickles" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "6) Cucumber" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "7) Jalapeno" + ANSI_RESET);

            int toppingChoice = getIntInput(ANSI_BLUE + "Enter your choice:" + ANSI_RESET);
            String topping;
            switch (toppingChoice) {
                case 1:
                    topping = "Lettuce";
                    break;
                case 2:
                    topping = "Tomato";
                    break;
                case 3:
                    topping = "Onion";
                    break;
                case 4:
                    topping = "Green Pepper";
                    break;
                case 5:
                    topping = "Pickles";
                    break;
                case 6:
                    topping = "Cucumber";
                    break;
                case 7:
                    topping = "Jalapeno";
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1) Lettuce, 2) Tomato, 3) Onion, 4) Green Pepper, 5) Pickles, 6) Cucumber, or 7) Jalapeno." + "\u001B[0m");                    continue;
            }
            sandwich.addRegularTopping(new RegularTopping(topping));
            break;
        }
    }

    private static void addPremiumTopping(Sandwich sandwich) {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_LIGHT_YELLOW = "\u001B[38;5;226m";
        String ANSI_RED = "\u001B[31m";


        while (true) {
            System.out.println(ANSI_LIGHT_YELLOW + "\nSelect Premium Topping:" + ANSI_RESET);
            System.out.println(ANSI_RED + "1) Meat" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "2) Cheese" + ANSI_RESET);

            int premiumChoice = getIntInput(ANSI_GREEN +"Enter your choice:" + ANSI_RESET);

            switch (premiumChoice) {
                case 1:
                    addMeat(sandwich);
                    break;
                case 2:
                    addCheese(sandwich);
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1) Meat or 2) Cheese." + "\u001B[0m");                    continue;
            }
            break;
        }
    }

    private static void addMeat(Sandwich sandwich) {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";


        while (true) {
            System.out.println();
            System.out.println(ANSI_RED + "Select Meat:" + ANSI_RESET);
            System.out.println(ANSI_RED + "1) Steak" + ANSI_RESET);
            System.out.println(ANSI_RED + "2) Ham" + ANSI_RESET);
            System.out.println(ANSI_RED + "3) Salami" + ANSI_RESET);
            System.out.println(ANSI_RED + "4) Roast Beef" + ANSI_RESET);
            System.out.println(ANSI_RED + "5) Chicken" + ANSI_RESET);
            System.out.println(ANSI_RED + "6) Bacon" + ANSI_RESET);

            int meatChoice = getIntInput(ANSI_GREEN + "Enter your choice:" + ANSI_RESET);
            String meat;
            switch (meatChoice) {
                case 1:
                    meat = "Steak";
                    break;
                case 2:
                    meat = "Ham";
                    break;
                case 3:
                    meat = "Salami";
                    break;
                case 4:
                    meat = "Roast Beef";
                    break;
                case 5:
                    meat = "Chicken";
                    break;
                case 6:
                    meat = "Bacon";
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1) Steak, 2) Ham, 3) Salami, 4) Roast Beef, 5) Chicken, or 6) Bacon." + "\u001B[0m");                    continue;
            }

            boolean extra = getYesNoInput(ANSI_RED + "Extra meat? (yes/no)" + ANSI_RESET);
            sandwich.addPremiumTopping(new PremiumTopping(meat, extra));
            break;
        }
    }




    private static void addCheese(Sandwich sandwich) {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_LIGHT_YELLOW = "\u001B[38;5;226m";
        String ANSI_GREEN = "\u001B[32m";



        while (true) {
            System.out.println(ANSI_LIGHT_YELLOW + "\nSelect Cheese:" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "1) American" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "2) Provolone" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "3) Cheddar" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "4) Swiss" + ANSI_RESET);

            int cheeseChoice = getIntInput(ANSI_GREEN + "Enter your choice:" + ANSI_RESET);
            String cheese;
            switch (cheeseChoice) {
                case 1:
                    cheese = "American";
                    break;
                case 2:
                    cheese = "Provolone";
                    break;
                case 3:
                    cheese = "Cheddar";
                    break;
                case 4:
                    cheese = "Swiss";
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1) American, 2) Provolone, 3) Cheddar, or 4) Swiss." + "\u001B[0m");                    continue;
            }

            boolean extra = getYesNoInput(ANSI_GREEN + "Extra cheese? (yes/no)" + ANSI_RESET);
            sandwich.addPremiumTopping(new PremiumTopping(cheese, extra));
            break;
        }
    }

    private static Drink createDrink() {
        int terminalWidth = 215;

        String ANSI_RESET = "\u001B[0m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_BLUE = "\u001B[34m";

        String size;
        while (true) {
            System.out.println(String.format("%" + (terminalWidth + (ANSI_BLUE + "DRINK SIZE SELECTION" + ANSI_RESET).length()) / 2 + "s", ANSI_BLUE + "DRINK SIZE SELECTION" + ANSI_RESET));
            System.out.println(ANSI_GREEN + "\nSelect Drink Size:" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "1) Small ($2.00)" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "2) Medium ($2.50)" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "3) Large ($3.00)" + ANSI_RESET);

            int sizeChoice = getIntInput(ANSI_GREEN + "Enter your choice:" + ANSI_RESET);
            switch (sizeChoice) {
                case 1:
                    size = "Small";
                    break;
                case 2:
                    size = "Medium";
                    break;
                case 3:
                    size = "Large";
                    break;
                default:
                    System.out.println("\u001B[31m" + "Invalid choice. Please enter 1) Small, 2) Medium, or 3) Large." + "\u001B[0m");                    continue;
            }
            break;
        }
        return new Drink(size);
    }

    private static void checkout(Order order) {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_BRONZE = "\u001B[38;5;180m";
        String ANSI_CYAN = "\u001B[36m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_RED = "\u001B[31m";

        System.out.println(ANSI_BRONZE + "\nOrder Summary:" + ANSI_RESET);
        System.out.println(order.getOrderDetails());
        System.out.println(ANSI_CYAN + "Saving order to file..." + ANSI_RESET);
        try {
            OrderService.saveOrderToFile(order);
            System.out.println(ANSI_GREEN + "Order saved successfully." + ANSI_RESET);
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error saving order: " + e.getMessage() + ANSI_RESET);
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

