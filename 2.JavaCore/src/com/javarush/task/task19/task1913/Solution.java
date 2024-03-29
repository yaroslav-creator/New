package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();           // вывод только цифр
        String result = outputStream.toString().replaceAll( "\\D", "" );
                                               // вывод только букв (и удаление дефисов и тире
       // String result1 = outputStream.toString().replaceAll( "[\\p{Digit},\\p{Pd}]", "" );

        System.setOut(consoleStream);
        System.out.println(result);
      //  System.out.println(result1);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
