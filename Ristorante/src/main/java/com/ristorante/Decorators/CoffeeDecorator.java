package com.ristorante.Decorators;
import com.ristorante.Enums.CoffeeDecoratorEnum;
import com.ristorante.ItemOrder;

public class CoffeeDecorator extends ItemOrderDecorator implements ItemOrder {

    private CoffeeDecoratorEnum decor;

    public CoffeeDecorator(ItemOrder target, CoffeeDecoratorEnum decor) {
        super(target);
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
            case milk:
                out += 0.20;
                break;
            case cacao:
                out += 0.25;
                break;
            case corretto:
                out += 0.70;
                break;
        }
        return out;
    }
}
