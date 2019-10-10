package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
   private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        Cook cook1 = new Cook( "Amigo" );
        cook1.addObserver( waiter );
       // cook1.setQueue( orderQueue );
        Thread amigoThread = new Thread(  );
        amigoThread.start();

        Cook cook2 = new Cook( "Diego" );
        cook2.addObserver( waiter );
       // cook2.setQueue( orderQueue );
        Thread diegoThread = new Thread(  );
        diegoThread.start();

//        StatisticManager statisticManager = StatisticManager.getInstance();
//        statisticManager.register( cook1 );
//        statisticManager.register( cook2 );


        List<Tablet> tabletList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Tablet tablet = new Tablet( i );
           // tablet.setQueue(orderQueue);
            tabletList.add( tablet );
        }

        Thread randomTaskThread = new Thread( new RandomOrderGeneratorTask( tabletList, ORDER_CREATING_INTERVAL ) );
        randomTaskThread.start();

        try {
            Thread.sleep( 1000 );
        } catch (InterruptedException e) {

        }
        randomTaskThread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
