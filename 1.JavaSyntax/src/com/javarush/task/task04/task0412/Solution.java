package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);//напишите тут ваш код
        int number = scanner.nextInt();

        if (number > 0) {
            System.out.println(number * 2);

        } else if (number < 0) {
            System.out.println(number + 1);

        } else if (number == 0) {
            System.out.println(number);
        }
    }

}