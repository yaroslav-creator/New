package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = 0;

        if (a > 0)
            d++;
        if (b > 0)
            d++;
        if (c > 0)
            d++;
        System.out.println(d);

    }
}
