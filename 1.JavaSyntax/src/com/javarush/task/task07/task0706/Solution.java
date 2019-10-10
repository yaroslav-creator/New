package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main (String[] args) throws Exception {

        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        int[] list = new int[15];

        for (int i = 0; i < list.length; i++) {

            list[i] = Integer.parseInt( reader.readLine() );

        }
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            if (i % 2 == 0) {
                sum += list[i];
            }
        }

        int sum1 = 0;
        for (int i = 0; i < list.length; i++) {
            if (i % 2 != 0) {
                sum1 += list[i];
            }
        }

        if (sum > sum1) {
            System.out.println( "В домах с четными номерами проживает больше жителей." );

        } else System.out.println( "В домах с нечетными номерами проживает больше жителей." );
    }
}
