package com.ristorante;

/**
 * ADT per la rappresentazione di un ordine
 */
public interface IOrder {

    String getID();
    int size();
    void addItem(ItemOrder pasta1, int i);
    void removeItem(ItemOrder pasta1, int i);
    float getTotalPrice();
    ItemOrder getItems( int i );


}
