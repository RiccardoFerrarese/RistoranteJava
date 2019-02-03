package com.ristorante.ConcreteItemOrder;

import com.ristorante.ItemOrder;

public class CoffeeItemOrder implements ItemOrder {

    private float cost = (float) 1.00;
    private String description = "Caffè ";

    @Override
    public float getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
