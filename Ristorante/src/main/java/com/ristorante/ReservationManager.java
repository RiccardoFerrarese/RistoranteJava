package com.ristorante;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ReservationManager {

    List<IReservation> reservations = new ArrayList<>();

    public void addReservation(IReservation reserv) throws ElementoGiaPresenteNellaListaException{

        for( IReservation r : reservations ) {
            if (reserv.getData().compareTo(r.getData()) == 0 && reserv.getTable() == r.getTable()) {
                throw new ElementoGiaPresenteNellaListaException();
            }
        }
                reservations.add( reserv );



    }

    public void removeReservatio() {


    }

    public List<IReservation> searchByClient(IClient client) {

        if( client == null ){
            throw  new NullPointerException();
        }

        List<IReservation> reserv = reservations.stream()
                .filter(r -> r.getClient() == client)
                .collect(Collectors.toList());

        return reserv;
    }

    public List<IReservation> searchByDate(Date date) {

        Objects.requireNonNull( reservations );
        List<IReservation> reserv = new ArrayList<>();
        for (IReservation r : reservations) {
            if (r.getData().compareTo( date ) == 0) {
                reserv.add(r);
            }
        }
        return reserv;
    }


}
