package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int g = 0;
        int d = 0;

        if ((a < 0) && (a != 0))
            g++;
        if ((b < 0) && (b != 0))
            g++;
        if ((c < 0) && (c != 0))
            g++;
        System.out.println("количество отрицательных чисел: " + g);

        if ((a > 0) && (a != 0))
            d++;
        if ((b > 0) && (b != 0))
            d++;
        if ((c > 0) && (c != 0))
            d++;
        System.out.println("количество положительных чисел: " + d);

    }
}
