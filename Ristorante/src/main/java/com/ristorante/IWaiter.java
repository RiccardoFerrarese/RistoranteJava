package com.ristorante;

import java.util.List;

/**
 * ADT per la rappresentazione di un cameriere
 * ognuna rappresentazione concreta avrà il nome
 * e un ID, ogni cameriere contiene la lista dei propri
 * ordini attivi
 */
public interface IWaiter{

    /**
     * @return ID cameriere
     */
    public String getID();
    public String getName();
    /**
     * procedura per controllare
     * gli ordini attivi del cameriere
     * @return la lista degli ordini
     */
    public List<IOrder> getActiveOrder();
    public void setOrder( IOrder order);
    public void sendOrderToCashDesk( IOrder order, ICashDesk cashDesk);



}
