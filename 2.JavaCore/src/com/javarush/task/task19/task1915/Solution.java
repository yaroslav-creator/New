package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {

        //считываем имя файла с консоли в который будет записан текст
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String fileName = reader.readLine();
        reader.close();

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        //Возвращаем как было
        System.setOut(consoleStream);

        //пишем в файл
        FileOutputStream fileOut = new FileOutputStream( fileName );
        outputStream.writeTo( fileOut );
        System.out.println(outputStream.toString());

        fileOut.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

