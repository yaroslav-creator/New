package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main (String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double color = Double.parseDouble(reader.readLine());

        if (color % 5 < 3) {
            System.out.println("зеленый");//напишите тут ваш код
        } else if (color % 5 < 4) {
            System.out.println("желтый");
        } else {
            System.out.println("красный");
        }
    }
}