package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private static String name;
        private static String lastName;
        private static int age;
        private static int height;
        private static int weight;
        private static int sex;

        public Human(String name){};
        public Human(String name, String lastName){};
        public Human(String name, String lastName, int age){};
        public Human(String name, String lastName, int age, int sex){};
        public Human(String name, int age){};
        public Human(String lastName, int age, int height){};
        public Human(int age, int height){};
        public Human(String lastName, int age, int height,int weight){};
        public Human(int age, int height,int weight, int sex){};
        public Human(String name,int age, int height,int weight, int sex){};

    }
}
