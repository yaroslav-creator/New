package com.javarush.task.task14.task1417;

public abstract class Money {
    private double amount; //В абстр. классе Money создай приватное поле amount типа double.

    public Money(double amount) {
        this.amount = amount;      // конструктор
    }

    public  double getAmount(){    //Создай публичный геттер для поля amount
        return amount;             //(public double getAmount())
    }

    public abstract String getCurrencyName();


}

