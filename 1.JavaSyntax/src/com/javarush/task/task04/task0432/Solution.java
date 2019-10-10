package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = scanner.nextInt();

        while (i > 0) {
            System.out.println(s);
            i--;
        }

    }
}
