package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

//Планшет Tablet создает заказы
public class Tablet  {
    final int number;//- это номер планшета, чтобы можно было однозначно установить, откуда поступил заказ.
    private static Logger logger = Logger.getLogger( Tablet.class.getName() );
    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    public Tablet(int number) {
        this.number = number;
    }

    //Метод,который будет создавать заказ из тех блюд, которые выберет пользователь.
    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);

        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            ConsoleHelper.writeMessage(null);
        }finally {
            launchOrder(order);
            return order;
        }
    }

    //Метод,который будет создавать тестовый заказ из тех блюд, которые есть, в меню
    public void createTestOrder() {
        Order order = null;
        try {
            order = new TestOrder(this);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            ConsoleHelper.writeMessage(null);
        } finally {
            launchOrder(order);
        }
    }

    private void launchOrder(Order order) {
        if (!order.isEmpty()) {
            ConsoleHelper.writeMessage(order.toString());
            AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            try {
                manager.processVideos();
            }catch (NoVideoAvailableException e){
                logger.log(Level.INFO, "No video is available for the order " + order);
            }

//            setChanged();
//            notifyObservers(order);
        }

    }

    @Override
    public String toString() {
        return "Tablet{" + "number=" + number + '}';
    }
}
