package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

public class Solution {
    public static double addTenPercent (int i) {

        double k = i + i / 10.0;

        return k;
    }

    public static void main (String[] args) {
        System.out.println(addTenPercent(9));
    }
}
