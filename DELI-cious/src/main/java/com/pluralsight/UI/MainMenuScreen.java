package com.pluralsight.UI;

import com.pluralsight.Models.*;
import java.util.Scanner;

public class MainMenuScreen {
    private OrderScreen orderScreen;
    private CheckoutScreen checkoutScreen;
    private ReceiptScreen receiptScreen;

    public MainMenuScreen(OrderScreen orderScreen, CheckoutScreen checkoutScreen, ReceiptScreen receiptScreen) {
        this.orderScreen = orderScreen;
        this.checkoutScreen = checkoutScreen;
        this.receiptScreen = receiptScreen;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1) Order");
            System.out.println("2) Checkout");
            System.out.println("3) View Receipt");
            System.out.println("4) Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    orderScreen.displayItems();
                    break;
                case 2:
                    checkoutScreen.displayOrderSummary();
                    checkoutScreen.calculateTotalPrice();
                    checkoutScreen.processPayment();
                    break;
                case 3:
                    receiptScreen.displayOrderDetails();
                    receiptScreen.displayPaymentInformation();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1) Order, 2) Checkout, 3) View Receipt, or 4) Exit.");
            }
        }
    }
}