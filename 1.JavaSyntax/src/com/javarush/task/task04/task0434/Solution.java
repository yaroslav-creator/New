package com.javarush.task.task04.task0434;


/* 
Таблица умножения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        int a = 1;
        while (a <= 10){

            int b = 1;
            while (b <= 10){

                System.out.printf("%4d" ,a * b);
                b++;
            }

            System.out.println();
            a++;

        }

    }
}
