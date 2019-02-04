package com.ristorante;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public class CashDeskOne implements ICashDesk {

    List<IOrder> orderToPay = new ArrayList<>();

    @Override
    public void addToPay(IOrder order) {
        orderToPay.add( order );
    }

    @Override
    public void closeOrder(IOrder order) {
        orderToPay.remove( order );
    }

    @Override
    public float pay(IClient client, IOrder order){

        float total = order.getTotalPrice();
        if(client.getSconto() != 0){
            return (client.getSconto() * total) / 100;
        } else {
            return total;
        }
    }
}
