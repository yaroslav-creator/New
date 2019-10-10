package com.javarush.task.task04.task0442;


/*
Суммирование
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        while (true) {

            int n = scanner.nextInt();
            sum = sum + n;
            if (n == -1)

                break;

        }

        System.out.println(sum);


    }
}


