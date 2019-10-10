package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main (String[] args) {
        System.out.println(convertEurToUsd(100, 1.45));
        System.out.println(convertEurToUsd(200, 1.45));
    }

    public static double convertEurToUsd (int eur, double course) {
        double USD = eur * course;
        int EUR = eur;
        double K = course;
        return USD;//напишите тут ваш код
    }

}
