package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (a == b)
            System.out.println("3");
        if (a == c)
            System.out.println("2");
        if (b == c)
            System.out.println("1");
    }
}
