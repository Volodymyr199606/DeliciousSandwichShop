package com.pluralsight;

import com.pluralsight.Models.Order;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Order> orders;

    public Shop() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        Receipt receipt = new Receipt(order);
        receipt.generateReceipt();
    }

    public List<Order> getOrders() {
        return orders;
    }
}