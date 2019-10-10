package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int i, j;

        for (i = 0; i < m; i++) {

            for (j = 0; j < n; j++) {
                System.out.print("8");

            }
            System.out.println();

        }

    }
}



