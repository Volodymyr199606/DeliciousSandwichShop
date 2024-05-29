package com.pluralsight.Models;

// Order.java


import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalCost() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        for (Product product : products) {
            details.append(product.getName())
                    .append(" - ")
                    .append(product.getDescription())
                    .append(" - $")
                    .append(product.getPrice())
                    .append("\n");
        }
        details.append("Total: $").append(getTotalCost());
        return details.toString();
    }
}
