package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        FileInputStream fis = new FileInputStream( reader.readLine() );

        try {
            int maxByte = Integer.MIN_VALUE;
            while (fis.available() > 0) {

                int tmp = fis.read();
                if (maxByte < tmp) {
                    maxByte = tmp;
                }
            }
            System.out.println( maxByte );
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}