package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Objects;
import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

//Cook(Повар) готовит заказы
public class Cook extends Observable implements Runnable {

    private StatisticManager statisticManager = StatisticManager.getInstance();
    private LinkedBlockingQueue<Order> queue;
    private String name;
    private boolean busy;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Cook(String name) {
        this.name = name;
    }

    public boolean isBusy() {
        return busy;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash( name );
    }

    public void startCookingOrder(Order order) {
        busy = true;

        ConsoleHelper.writeMessage( "Start cooking - " + order + ", cooking time " + order.getTotalCookingTime() + "min" );

        StatisticManager.getInstance().register( new CookedOrderEventDataRow(
                order.getTablet().toString(), name,
                order.getTotalCookingTime() * 60, order.getDishes() ) );

        try {
            Thread.sleep( order.getTotalCookingTime() * 10 );
        } catch (InterruptedException e) {

        }
        setChanged();
        notifyObservers( order );

        busy = false;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            try {
                startCookingOrder(queue.take());
                Thread.sleep(10);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
//        while (!Thread.currentThread().isInterrupted() && queue.peek() != null) {
//            if (!isBusy()) {
//                Order poll = queue.poll();
//                if (poll != null)
//                    startCookingOrder(poll);
////                Thread thread = new Thread(  );
//            }
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    //    @Override
//    public void run() {
//        while (!Thread.currentThread().isInterrupted() && queue.peek() != null) {
//            if (!isBusy()) {
//                Order poll = queue.poll();
//                if (poll != null)
//                    startCookingOrder(poll);
//                Thread thread = new Thread(  );
//            }
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}



