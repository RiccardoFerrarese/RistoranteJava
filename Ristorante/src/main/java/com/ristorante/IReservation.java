package com.ristorante;

import java.util.Date;

public interface IReservation {

    ITable getTable();
    IClient getClient();
    Date getData();

}
