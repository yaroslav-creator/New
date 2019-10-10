package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    private String name ;
    private int age = 3;
    private int weight = 5;
    private String address = null;
    private String color = "grey";

    public Cat (String name){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public Cat (String name,int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
    }

    public Cat (String name,int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;

    }

    public Cat (int weight,String color) {
        this.weight = weight;
        this.color = color;
        this.age = age;

    }

    public Cat (int weight,String color,String address) {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = age;


    }


    public static void main(String[] args) {

    }
}
