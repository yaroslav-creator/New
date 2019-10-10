package com.javarush.task.task12.task1229;

/* 
Родитель класса CTO
*/

public class Solution {

    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman {
        public void workHard();
    }
    public static class Worker {
        public void workHard() {};// Создаем доп.класс с одним методом
    }

    public static class CTO extends Worker implements Businessman {
   // Класс СТО наследуем от доп.класса Worker и реализуем интерфейс Businessman

    }
}
