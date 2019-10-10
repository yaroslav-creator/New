package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {

        StringBuilder result = new StringBuilder();

        int digit = (a <= b) ? (b - a + 1) : (a - b + 1);

        for (int i = a; ; i = (a <= b) ? (i + 1) : (i - 1)) {
            if (digit-- == 0) break;

            result.append( " " ).append( i );
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt( 100 );
        numberB = random.nextInt( 1000 );
        System.out.println( getAllNumbersBetween( numberA, numberB ) );
        System.out.println( getAllNumbersBetween( numberB, numberA ) );
    }
}