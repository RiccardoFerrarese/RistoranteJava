package com.ristorante;

public class BaseClient implements IClient {

    String name;
    float sconto;

    public BaseClient( String name, float sconto ){
        this.name = name;
        this.sconto = sconto;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getSconto() {
        return sconto;
    }
}
