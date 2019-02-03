package com.ristorante.Decorators;

import com.ristorante.ItemOrder;

public abstract class ItemOrderDecorator implements ItemOrder {

    private ItemOrder order;
    public ItemOrderDecorator(ItemOrder order) {
        this.order = order;
    }

    @Override
    public String getDescription() {
        return order.getDescription();
    }

    public float getCost(){
        return order.getCost();
    }
}
