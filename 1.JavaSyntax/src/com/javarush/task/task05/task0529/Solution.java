package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true){
            String s = reader.readLine();
            if (s.equals("сумма")) {
                break;
            }
            int n = Integer.parseInt(s);
            sum += n;
        }
        System.out.println(sum);
    }
}