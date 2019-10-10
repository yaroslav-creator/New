package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        FileInputStream fis = new FileInputStream( reader.readLine() );

        try {
            int minByte = Integer.MAX_VALUE;
            while (fis.available() > 0) {

                int tmp = fis.read();
                if (minByte > tmp) {
                    minByte = tmp;
                }
            }
            System.out.println( minByte );
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}

