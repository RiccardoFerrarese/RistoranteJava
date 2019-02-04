package com.ristorante.Decorators;

import com.ristorante.ConcreteItemOrder.Pasta;
import com.ristorante.Enums.PastaDecoratorEnum;
import com.ristorante.ItemOrder;

public class PastaDecorator extends ItemOrderDecorator implements ItemOrder {

    PastaDecoratorEnum decor;
    public PastaDecorator(ItemOrder order, PastaDecoratorEnum decor) {
            super(order);
            this.decor = decor;

    }

    @Override
    public String getDescription() {
        return super.getDescription().concat(", with " +  decor.toString() );
    }



    @Override
    public float getCost() {

        float out = super.getCost();
        switch (decor) {
            case tomatoSauce:
                out+= 3;
                break;
            case carbonara:
                out+= 5;
                break;
            case cozze:
                out+= 8;
                break;
        }
        return out;
    }
}
