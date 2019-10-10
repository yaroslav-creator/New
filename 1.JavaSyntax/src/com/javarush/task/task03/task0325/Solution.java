package com.javarush.task.task03.task0325;

import java.io.*;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String n = bufferedReader.readLine();
        System.out.println("Я буду зарабатывать $"+n +" в час");//напишите тут ваш код
    }
}
