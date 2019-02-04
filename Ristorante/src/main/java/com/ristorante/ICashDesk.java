package com.ristorante;

public interface ICashDesk {

    void addToPay(IOrder order);
    void closeOrder(IOrder order);
    public float pay(IClient client, IOrder order);

}
