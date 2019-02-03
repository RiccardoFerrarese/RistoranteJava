package com.ristorante;

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
}
