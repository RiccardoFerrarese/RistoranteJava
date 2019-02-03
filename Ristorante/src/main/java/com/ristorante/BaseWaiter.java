package com.ristorante;

import java.util.ArrayList;
import java.util.List;

public class BaseWaiter implements IWaiter {

    String iD;
    String name;
    List<IOrder> activeOrder = new ArrayList<>();

    public BaseWaiter(BuilderWaiter builder) {
        this.iD = builder.iD;
        this.name = builder.name;
    }

    @Override
    public String getID() {
        return iD;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<IOrder> getActiveOrder() {
        return activeOrder;
    }

    @Override
    public void setOrder( IOrder order) {
        activeOrder.add( order );
    }

    @Override
    public void sendOrderToCashDesk(IOrder order, ICashDesk cashDesk) {
        cashDesk.addToPay( order );
    }

    // INNER BUILDER

    public static class BuilderWaiter{

        String iD;
        String name;

        public BuilderWaiter( String name){
            this.name = name;
        }

        public BuilderWaiter whitID( String ID){
            this.iD = ID;
            return this;
        }

        public IWaiter build(){
            return new BaseWaiter(this );

        }
    }
}
