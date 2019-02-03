package com.ristorante;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationManager {

    List<IReservation> reservations = new ArrayList<>();

    public void addReservation( IReservation reserv){
        reservations.add( reserv );
    }

    public  void removeReservatio( ){
        //TODO
    }

    public List<IReservation> searchByClient( IClient client ){

        List<IReservation> reserv = reservations.stream()
                .filter( r -> r.getClient() == client )
                .collect( Collectors.toList() );

        return reserv;
    }
}
