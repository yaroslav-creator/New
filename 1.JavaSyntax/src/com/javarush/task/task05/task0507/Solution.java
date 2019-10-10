package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.*;
import java.io.InputStream;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double sum = 0;
        double sum1;

        while (true) {
            int n = scanner.nextInt();

            count++;
            sum = sum + n;
            sum1 = sum + 1;

            if (n == -1)
                break;
        }

        System.out.println(sum1/(count -1));

    }
}