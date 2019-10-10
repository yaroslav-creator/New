package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();


        if (((a >= 1) && (a < 10)) && (a % 2 == 0))
            System.out.println("четное однозначное число");

        if (((a >= 1) && (a < 10)) && (a % 2 != 0))
            System.out.println("нечетное однозначное число");


        if (((a >= 10) && (a <100)) && (a % 2 == 0))
            System.out.println("четное двузначное число");

        if (((a >= 10) && (a < 100)) && (a % 2 != 0))
            System.out.println("нечетное двузначное число");


        if (((a >= 100) && (a < 1000)) && (a % 2 == 0))
            System.out.println("четное трехзначное число");

        if (((a >= 100) && (a < 1000)) && (a % 2 != 0))
            System.out.println("нечетное трехзначное число");
    }
}
