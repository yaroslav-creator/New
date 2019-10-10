package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/

import java.io.*;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int max1 = max(a, b);
        int max2 = max(b, c);
        int max3 = max(c, a);

      //  System.out.println(min(max1,max2,max3));

        int min1 = min(max1, max2);
        int min2 = min(max2, max3);
        System.out.println(min(min1,min2));
    }

//    private static int min (int n1, int n2, int n3) {
//        int min1 = Math.min(n1, n2);
//        int min2 = Math.min(n2, n3);
//        return Math.min(min1,min2);
//    }
}
