package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

import static java.lang.Math.abs;

public class Solution {
    public static void main (String[] args) {
        displayClosestToTen(8, 11);
        displayClosestToTen(7, 14);
    }

    public static void displayClosestToTen (int a, int b) {

        if (abs(10 - a) < (abs(10 - b))) {
            System.out.println((a));

        } else if (abs(10 - a) > (abs(10 - b))) {
            System.out.println((b));

        } else if (abs(10 - a) == (abs(10 - b))) {
            System.out.println((a | b));

        }

    }

    public static int abs (int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}