package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main (String[] args) {

        print(1, 1);
        print(2, 2);
        print(3, 3);
        print(4, 4);
        print(5, 5);
        print(6, 6);
        print(7, 7);
        print(8, 8);
        print(9, 9);
        print(10, 10);

    }

    static void print (int a, int c) {

        int b = (a * 10) + a;

        while (a != b) {
            System.out.print(a + " ");
            a = a + c;
        }

        if (a == b) {
            System.out.println();
        }
    }
}