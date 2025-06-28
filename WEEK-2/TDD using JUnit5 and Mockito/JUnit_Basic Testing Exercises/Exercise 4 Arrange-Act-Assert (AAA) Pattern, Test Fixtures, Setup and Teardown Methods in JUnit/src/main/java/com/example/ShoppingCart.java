package com.example;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<String> items;
    private final List<Double> prices;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.prices = new ArrayList<>();
    }

    public void addItem(String item, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.items.add(item);
        this.prices.add(price);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public double getTotalPrice() {
        return this.prices.stream().mapToDouble(Double::doubleValue).sum();
    }

    public void clear() {
        this.items.clear();
        this.prices.clear();
    }
}
