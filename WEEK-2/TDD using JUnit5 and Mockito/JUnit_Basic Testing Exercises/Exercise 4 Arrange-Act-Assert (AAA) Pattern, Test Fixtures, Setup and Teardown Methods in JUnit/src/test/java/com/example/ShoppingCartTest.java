package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    @Before
    public void setUp() {
        cart = new ShoppingCart();
    }

    @After
    public void tearDown() {
        cart.clear();
        cart = null;
    }

    @Test
    public void testCartIsInitiallyEmpty() {
        int itemCount = cart.getItemCount();
        assertEquals(0, itemCount);
    }

    @Test
    public void testAddItemIncreasesCount() {
        cart.addItem("Milk", 2.50);
        assertEquals(1, cart.getItemCount());
        assertEquals(2.50, cart.getTotalPrice(), 0.001);
    }

    @Test
    public void testClearRemovesAllItems() {
        cart.addItem("Bread", 1.99);
        cart.addItem("Cheese", 5.49);
        cart.clear();
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getTotalPrice(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithNegativePriceThrowsException() {
        cart.addItem("Bad Item", -10.00);
    }
}
