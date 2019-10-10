package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.math.*;
import java.util.ArrayList.*;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner( System.in );
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();

        int nums[] = {a, b, c, d, e};
        int f, g, h;
        int size = 5;



        for (f = 1; f < size; f++)
            for (g = size - 1; g >= f; g--) {
                if (nums[g - 1] > nums[g]) {
                    h = nums[g - 1];
                    nums[g - 1] = nums[g];
                    nums[g] = h;
                }
            }
        for (int i = 0; i < size; i++)
            System.out.println( nums[i] );

    }

}
