package com.javarush.task.task27.task2712.kitchen;

      //Блюдо
public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    //duration - продолжительность
    private int duration;

    public int getDuration() {
        return duration;
    }

    Dish(int duration){
        this.duration = duration;
    }

    public static String allDishesToString() {
        return "Fish, Steak, Soup, Juice, Water";
    }
}
