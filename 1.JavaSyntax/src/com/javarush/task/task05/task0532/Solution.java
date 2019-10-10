package com.javarush.task.task05.task0532;

import java.io.*;
import java.util.Scanner;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner( System.in );
        int n = scanner.nextInt();
        int maximum = 0;

        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (i == 0) {
                maximum = a;
            }

            if (a > maximum) {
                maximum = a;

            }

        }
        System.out.println( maximum );


    }
}
