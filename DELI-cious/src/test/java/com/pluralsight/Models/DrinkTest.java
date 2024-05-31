package com.pluralsight.Models;

import com.pluralsight.Models.Subclasses.Drink;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DrinkTest {
    @Test
    public void testSmallDrink() {
        Drink drink = new Drink("Small");
        assertEquals(drink.getPrice(), 2.00, 0.001);
        assertEquals(drink.getDescription(), "Size: Small");
    }

    @Test
    public void testMediumDrink() {
        Drink drink = new Drink("Medium");
        assertEquals(drink.getPrice(), 2.50, 0.001);
        assertEquals(drink.getDescription(), "Size: Medium");
    }

    @Test
    public void testLargeDrink() {
        Drink drink = new Drink("Large");
        assertEquals(drink.getPrice(), 3.00, 0.001);
        assertEquals(drink.getDescription(), "Size: Large");
    }

    @Test
    public void testInvalidDrinkSize() {
        try {
            new Drink("Extra Large");
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Invalid size");
        }
    }
}