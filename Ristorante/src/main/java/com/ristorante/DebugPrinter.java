package com.ristorante;

import java.util.List;

public class DebugPrinter {

    public String prettyPrint(ItemOrder target) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tItem: ").append(target.getDescription());
        sb.append("\n\tPrice: ").append(target.getCost()).append(" €");
        return sb.toString();
    }

    public String prettyPrint( IWaiter target){
        StringBuilder sb = new StringBuilder();
        sb.append("\nWaiter ").append(target.getName());
        sb.append("\nWith ID ~ ").append(target.getID());
        sb.append("\n\tActive orders: ");
        for( IOrder order: target.getActiveOrder()){
            sb.append("\t\t\t" + this.prettyPrint(order) );
        }
        sb.append("\n\t----------------------------");

        return sb.toString();
    }

    public String prettyPrint( IOrder target){
        StringBuilder sb = new StringBuilder();
        sb.append( "\n\tOrdine: " + target.getID());

        for(int i = 0; i < target.size(); i++ ){
            sb.append("\n\t\t\t\t" + this.prettyPrint( target.getItems( i ) ));
        }

        sb.append("\n\t\t\tTotal price: " + target.getTotalPrice() + " €");
        return sb.toString();
    }

    public String prettyPrint( List<IOrder> target){
        StringBuilder sb = new StringBuilder();
        if( target != null) {
            for (int i = 0; i < target.size() -1; i++) {
                sb.append("\n" + this.prettyPrint( target.get(i) ));
            }
            return sb.toString();
        } else {
            return sb.append(" ordini non presenti").toString();
        }
    }

    public String prettyPrint( IReservation target){
        StringBuilder sb = new StringBuilder();
        sb.append("\nReservetion at name: " + target.getClient().getName()  );
        sb.append("\nFor the table: " + target.getTable().getID() );
        sb.append("\nIn date: "+ target.getData());

        return sb.toString();
    }

    public String prettyPrint( ReservationManager target ){
        StringBuilder sb = new StringBuilder();
        if( target != null){
            sb.append("\nLista Prenotazioni: ");

            for( IReservation r : target.reservations ){
                sb.append("\n\t\t" + this.prettyPrint( r ));
            }

            sb.append("\n------------------");

            return  sb.toString();
        } else {
            return sb.append("\nNon ci sono ordini presenti").toString();
        }
    }
    /*
    public String prettyPrint( List<IReservation> target ){
        StringBuilder sb = new StringBuilder();
        if( target != null){
            sb.append("\nLista Prenotazioni: ");

            for( IReservation r : target ){
                sb.append("\n\t\t" + this.prettyPrint( r ));
            }

            sb.append("\n------------------");

            return  sb.toString();
        } else {
            return sb.append("\nNon ci sono ordini presenti").toString();
        }

    }
    */
}
