package com.ristorante.ConcreteItemOrder;

import com.ristorante.ItemOrder;

public class Pasta implements ItemOrder{

    private float cost = 10;
    private String description= "Pasta";

    @Override
    public float getCost() {
        return cost;
    }

    @Override
    public String getDescription() {
        return description;
    }


}
