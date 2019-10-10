package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream consolePrint = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream( outputStream );
        System.setOut( stream );

        testString.printSomething();
        System.setOut( consolePrint );

        String[] result = outputStream.toString().split( "\\n" );
        int count = 0;
        for (String results : result) {  // пока есть строки, что загнаны в наш массив
            System.out.println( results ); //выводим 1 строку
            count++;                        // счетчик 2 строки

            if ((count % 2) == 0) {         // если строка 3 выводим текст
                System.out.println( "JavaRush - курсы Java онлайн" );
            }
        }
    }
    public static class TestString {
        public void printSomething() {
            System.out.println( "first" );
            System.out.println( "second" );
            System.out.println( "third" );
            System.out.println( "fourth" );
            System.out.println( "fifth" );
        }
    }
}
