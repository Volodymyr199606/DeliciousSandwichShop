package com.pluralsight.UI;

import com.pluralsight.Models.*;
import com.pluralsight.Models.AbstractClass.Product;

import java.util.List;

public class OrderSummary {
    private Order currentOrder;

    public OrderSummary(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public void displayOrderSummary() {
        System.out.println("Order Summary:");
        List<Product> products = currentOrder.getProducts();
        for (Product product : products) {
            System.out.println(product.getName() + ": " + product.getPrice());
        }
    }
}