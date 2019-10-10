package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

import java.time.Year;
import java.util.Scanner;


public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);//напишите тут ваш код
        int year = scanner.nextInt();

        int a = 366;
        int b = 365;

        if (year % 4 != 0 || (year % 100 == 0 & year % 400 != 0))
            System.out.println("количество дней в году: " + b);

        else System.out.println("количество дней в году: " + a);


    }

}