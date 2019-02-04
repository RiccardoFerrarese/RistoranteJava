package com.ristorante;

public class ElementoGiaPresenteNellaListaException extends Exception {
    String message = "Prenotazione già presente\nTrovato un elemento con le stesse caratteristiche\nImpossibile da aggiungere";

    public ElementoGiaPresenteNellaListaException(){
        System.err.println( message );
    }

}
