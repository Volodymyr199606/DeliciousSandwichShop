package com.pluralsight.Models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegularToppingTest {

    @Test
    void getName() {
        RegularTopping topping = new RegularTopping("Onion");
        assertEquals("Onion", topping.getName());
    }

    @Test
    void getCost() {
        RegularTopping topping = new RegularTopping("Onion");
        assertEquals(0.0, topping.getCost());
    }
}