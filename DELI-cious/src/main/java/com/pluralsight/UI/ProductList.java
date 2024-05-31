package com.pluralsight.UI;

import com.pluralsight.Models.AbstractClass.Product;

import java.util.List;

public class ProductList {
    private List<Product> products;

    public ProductList(List<Product> products) {
        this.products = products;
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product.getName() + ": " + product.getPrice());
        }
    }
}