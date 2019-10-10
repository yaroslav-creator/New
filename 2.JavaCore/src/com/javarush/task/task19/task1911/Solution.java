package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //создаём динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        //создаём адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);

        //устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //преобразуем записанные в наш массив данные в строку текст в заглавные буквы
        String result = outputStream.toString().toUpperCase();

        //возвращаем все как было
        System.setOut(consoleStream);

        //Выводим модифицированную строку
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
