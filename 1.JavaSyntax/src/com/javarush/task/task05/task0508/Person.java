package com.javarush.task.task05.task0508;

/* 
Геттеры и сеттеры для класса Person
*/

public class Person {
   public String name;
    public int age;
    public char sex;

    public void setName (String name) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public int getAge () {
        return age;
    }

    public void setSex (char sex) {
        this.sex = sex;
    }

    public char getSex () {
        return sex;
    }

    public static void main(String[] args) {

    }
}
