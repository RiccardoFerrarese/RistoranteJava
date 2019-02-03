package com.ristorante.Decorators;

import com.ristorante.ItemOrder;

public class ServicePriceDecorator extends ItemOrderDecorator {

    float servicePrice;

    public ServicePriceDecorator(ItemOrder order, float servicePrice) {
        super(order);
        this.servicePrice = servicePrice;
    }

    @Override
    public float getCost(){
        return super.getCost() + servicePrice;
    }
}
