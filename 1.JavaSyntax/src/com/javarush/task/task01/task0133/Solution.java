package com.javarush.task.task01.task0133;

/* 
Не думать о секундах…
*/

public class Solution {
    public static void main (String[] args) {
        int i = secondAfter15(30) ;
        String string = Integer.toString(i);
        System.out.println(string);
    }

    public static int secondAfter15 (int sec) {
        double a = 15.50 * 3600;
        int b = 15 * 3600;
        int c = (int) a;
        int e = c - b;
        return (e);
    }


}