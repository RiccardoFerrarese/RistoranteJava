package com.ristorante;

import java.util.ArrayList;
import java.util.List;

public class BaseOrder implements IOrder {

    List<ItemOrder> items = new ArrayList<>();
    String ID;

    public BaseOrder( String ID){
        this.ID = ID;
    }

    @Override
    public ItemOrder getItems(int i) {
        return items.get(i);
    }

    @Override
    public String getID() {
        return ID;
    }

    public int size() {
        return items.size();
    }

    @Override
    public void addItem(ItemOrder itemOrder, int i) {
        items.add( itemOrder );

    }

    @Override
    public void removeItem(ItemOrder itemOrder, int count) {

        items.remove( itemOrder );
    }


    public float getTotalPrice(){
        float total = 0;
        for( ItemOrder itemOrder : items){
            total += itemOrder.getCost();
        }

        return total;
    }
}
