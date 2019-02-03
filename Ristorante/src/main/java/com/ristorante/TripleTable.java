package com.ristorante;

public class TripleTable implements ITable {

    int seats = 3;
    String ID;

    public TripleTable( String ID){
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
