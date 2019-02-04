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

    public static void main(String[] args) throws ElementoGiaPresenteNellaListaException {

        DebugPrinter dp  = new DebugPrinter();
        ICashDesk cashDesk = new CashDeskOne();

        IWaiter waiter1 = new BaseWaiter.BuilderWaiter("Fabio")
                .whitID("01")
                .build();

        IWaiter waiter2 = new BaseWaiter.BuilderWaiter("Giorgio")
                .whitID("02")
                .build();

        IOrder order1 = new BaseOrder("0001");
        IOrder order2 = new BaseOrder( "0002");

        ItemOrder pasta1 = new Pasta();
        pasta1 = new PastaDecorator( pasta1, PastaDecoratorEnum.tomatoSauce);
        order1.addItem( pasta1, 1);


        ItemOrder pasta2 = new Pasta();
        pasta2 = new PastaDecorator( pasta2, PastaDecoratorEnum.carbonara);

        order1.addItem((ItemOrder) pasta2, 1);

        ItemOrder pasta3 = new Pasta();
        pasta3 = new PastaDecorator( pasta3, PastaDecoratorEnum.cozze);
        order2.addItem((ItemOrder) pasta3, 1);

        ItemOrder coffe = new CoffeeItemOrder();
        coffe = new CoffeeDecorator( coffe, CoffeeDecoratorEnum.milk);
        coffe = new CoffeeDecorator(coffe, CoffeeDecoratorEnum.corretto);
        order1.addItem((ItemOrder) coffe, 2);

        ItemOrder coffe2 = new CoffeeItemOrder();
        coffe2 = new CoffeeDecorator( coffe2, CoffeeDecoratorEnum.cacao);
        order2.addItem((ItemOrder) coffe2, 1);

        waiter1.setOrder( order1 );
        waiter2.setOrder( order2 );

        ITable table1 = new SingleTable("01");
        ITable table2 = new SingleTable("02");
        ITable table3 = new TripleTable( "03");

        IClient client1 = new BaseClient("Riccardo", 0);
        IClient client2 = new BaseClient("Lara", 10);

        IReservation reservation = new BaseReservetion( table1, client1, new Date(2019, 03, 02, 19, 20));
        IReservation reservation1 = new BaseReservetion( table2, client2, new Date(2019, 03, 02, 17, 45));


        IClient diPippa = new BaseClient("Pietro Di Pippa", 20);
        IReservation reservation2 = new BaseReservetion( table1, diPippa, new Date(2019, 02, 02, 19, 30));

        ReservationManager reservationManager = new ReservationManager();

        reservationManager.addReservation( reservation1 );
        reservationManager.addReservation( reservation2 );
        reservationManager.addReservation( reservation );
        reservationManager.addReservation( reservation1 );


        System.out.println( dp.prettyPrint( waiter1 ));
        System.out.println( dp.prettyPrint( waiter2 ));

        System.out.println( dp.prettyPrint( reservationManager ));


        System.out.println( dp.prettyPrintReservatio( reservationManager.searchByClient( client1 ) ));
        System.out.println( dp.prettyPrintReservatio( reservationManager.searchByDate( new Date( 2019, 03, 02, 17, 45) ) ));
        System.out.println( cashDesk.pay( diPippa, order1));


    }
}
