package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main (String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber (int number) {
//        int number = 546;
        int b;
        int sum = 0;

        b = number % 10;
        sum = sum + b;

        number = number / 10;

        b = number % 10;
        sum = sum + b;

        number = number / 10;
        sum = sum + number;


        return sum;
        //напишите тут ваш код
    }
}