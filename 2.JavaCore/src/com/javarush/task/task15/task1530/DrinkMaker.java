package com.javarush.task.task15.task1530;

public abstract class DrinkMaker {
//создаем класс DrinkMaker с тремя абстрактными методами
      public abstract void getRightCup();
      public abstract void putIngredient();
      public abstract void pour();
/* В классе DrinkMaker создаем и реализуем метод void makeDrink(),
который готовит напиток в такой последовательности:
выбирает чашку, кладет ингредиенты, заливает жидкостью.*/

      public void makeDrink(){
            getRightCup();
            putIngredient();
            pour();
      }
}
