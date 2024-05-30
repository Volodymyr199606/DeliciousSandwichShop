package com.pluralsight.UI;

import com.pluralsight.Models.*;

public class ReceiptScreen {
    private Order currentOrder;

    public ReceiptScreen(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public void displayOrderDetails() {
        System.out.println("Order Details:");
        System.out.println(currentOrder.getOrderDetails());
    }

    public void displayPaymentInformation() {
        // Here you would typically display the payment information.
        // As this is a simulation, we'll just print a message.
        System.out.println("Payment Information:");
        System.out.println("Payment processed successfully!");
    }
}