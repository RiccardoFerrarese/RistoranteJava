import com.ristorante.*;
import com.ristorante.ConcreteItemOrder.CoffeeItemOrder;
import com.ristorante.ConcreteItemOrder.Pasta;
import com.ristorante.Decorators.CoffeeDecorator;
import com.ristorante.Decorators.ItemOrderDecorator;
import com.ristorante.Decorators.PastaDecorator;
import com.ristorante.Enums.CoffeeDecoratorEnum;
import com.ristorante.Enums.PastaDecoratorEnum;


import java.util.Date;

public class Main {

    public static void main(String[] args){

        DebugPrinter dp  = new DebugPrinter();

        IWaiter waiter1 = new BaseWaiter.BuilderWaiter("Fabio")
                .whitID("01")
                .build();

        IWaiter waiter2 = new BaseWaiter.BuilderWaiter("Giorgio")
                .whitID("02")
                .build();

        IOrder order1 = new BaseOrder("0001");
        IOrder order2 = new BaseOrder( "0002");

        ItemOrder pasta1 = new Pasta();
        order1.addItem( pasta1, 1);

        pasta1 = new PastaDecorator( pasta1, PastaDecoratorEnum.tomatoSauce);

        ItemOrder pasta2 = new Pasta();
        order1.addItem((ItemOrder) pasta2, 1);

        pasta2 = new PastaDecorator( pasta2, PastaDecoratorEnum.carbonara);

        ItemOrder pasta3 = new Pasta();
        order2.addItem((ItemOrder) pasta3, 1);

        pasta3 = new PastaDecorator( pasta3, PastaDecoratorEnum.cozze);

        ItemOrder coffe = new CoffeeItemOrder();
        order1.addItem((ItemOrder) coffe, 2);
        coffe = new CoffeeDecorator( coffe, CoffeeDecoratorEnum.milk);
        coffe = new CoffeeDecorator(coffe, CoffeeDecoratorEnum.corretto);

        ItemOrder coffe2 = new CoffeeItemOrder();
        order2.addItem((ItemOrder) coffe2, 1);
        coffe2 = new CoffeeDecorator( coffe2, CoffeeDecoratorEnum.cacao);

        waiter1.setOrder( order1 );
        waiter2.setOrder( order2 );

        ITable table1 = new SingleTable("01");
        ITable table2 = new SingleTable("02");
        ITable table3 = new TripleTable( "03");

        IClient client1 = new BaseClient("Riccardo", 0);
        IClient client2 = new BaseClient("Lara", 10);

        IReservation reservation = new BaseReservetion( table1, client1, new Date(2019, 03, 02, 19, 20));
        IReservation reservation1 = new BaseReservetion( table2, client2, new Date(2019, 03, 05, 17, 45));

        ReservationManager reservationManager = new ReservationManager();
        reservationManager.addReservation( reservation );
        reservationManager.addReservation( reservation1 );


        System.out.println( dp.prettyPrint( waiter1 ));
        System.out.println( dp.prettyPrint( waiter2 ));

        System.out.println( dp.prettyPrint( reservationManager ));

        System.out.println( reservationManager.searchByClient( client1 ).toString() );


    }
}
