package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    public String name;
    public int age = 3;
    public int weight = 5;
    public String address = null;
    public String color = "grey";

    public void initialize (String name) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;

    }

    public void initialize (String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;

    }

    public void initialize (String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "red";
        this.address = null;
    }

    public void initialize (int weight, String color) {
        this.weight = weight;
        this.color = color;
        this.age = age;
        this.name = null;
        this.address = null;
    }

    public void initialize (int weight, String color, String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = age;
        this.name = null;

    }


    public static void main (String[] args) {


    }
}
