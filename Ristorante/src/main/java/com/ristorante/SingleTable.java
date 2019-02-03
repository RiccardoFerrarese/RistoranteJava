package com.ristorante;

public class SingleTable implements ITable {

    int seats = 2;
    String ID;

    public SingleTable( String ID){
        this.ID = ID;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    @Override
    public String getID() {
        return ID;
    }

}
