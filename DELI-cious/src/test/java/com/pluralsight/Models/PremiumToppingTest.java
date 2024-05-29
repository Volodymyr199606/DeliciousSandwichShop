package com.pluralsight.Models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PremiumToppingTest {

    @Test
    void getName() {
        PremiumTopping topping = new PremiumTopping("Steak", false);
        assertEquals("Steak", topping.getName());
    }

    @Test
    void isExtra() {
        PremiumTopping topping = new PremiumTopping("Steak", false);
        assertFalse(topping.isExtra());
    }

    @Test
    void getCost() {
        PremiumTopping topping = new PremiumTopping("Steak", false);
        assertEquals(2.00, topping.getCost(8));
    }

    @Test
    void getCostWithExtra() {
        PremiumTopping topping = new PremiumTopping("Steak", true);
        assertEquals(3.00, topping.getCost(8));
    }
}