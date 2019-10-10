package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

//Order (заказ)
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    //Метод, который посчитает суммарное время приготовления всех блюд в заказе.
    public int getTotalCookingTime() {
        int time = 0;
        for (Dish d : dishes)
            time += d.getDuration();

        return time;
    }

    //метод, который будет определять, есть ли какие либо блюда в заказе.
    public Tablet getTablet() {
        return tablet;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    @Override
    public String toString() {
        return dishes.isEmpty() ? "" : "Your order: " + dishes + " of " + tablet;
    }
}