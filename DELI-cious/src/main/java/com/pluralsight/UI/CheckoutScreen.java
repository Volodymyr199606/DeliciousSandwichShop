package com.pluralsight.UI;

import com.pluralsight.Models.*;
import com.pluralsight.Models.AbstractClass.Product;

public class CheckoutScreen {
    private Order currentOrder;

    public CheckoutScreen(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public void displayOrderSummary() {
        System.out.println("Order Summary:");
        System.out.println(currentOrder.getOrderDetails());
    }

    public void calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Product product : currentOrder.getProducts()) {
            totalPrice += product.getPrice();
        }
        System.out.println("Total Price: " + totalPrice);
    }

    public void processPayment() {
        // Here you would typically interact with a payment gateway to process the payment.
        // As this is a simulation, we'll just print a message.
        System.out.println("Processing payment...");
        System.out.println("Payment processed successfully!");
    }
}