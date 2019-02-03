package com.ristorante;

import java.util.Date;

public class BaseReservetion implements IReservation {

    private ITable table;
    private IClient client;
    private Date date;

    public BaseReservetion(ITable table, IClient client, Date date) {
        this.table = table;
        this.client = client;
        this.date = date;
    }

    @Override
    public ITable getTable() {
        return table;
    }

    @Override
    public IClient getClient() {
        return client;
    }

    @Override
    public Date getData() {
        return date;
    }

}
