package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        while (true) {
            String a = reader.readLine();
            if (a.equals( "exit" )) {
                break;
            }
            if (a.contains( "." )) {
                try {
                    Double tmp = Double.parseDouble( a );
                    print( tmp );
                    continue;
                } catch (NumberFormatException e) {

                }

            }
            try {
                Short tmp = Short.parseShort( a );
                if (tmp > 0 && tmp < 128) {
                    print( tmp );
                    continue;
                }
            } catch (NumberFormatException e) {

            }
            try {
                Integer tmp = Integer.parseInt( a );
                if (tmp <= 0 || tmp >= 128) {
                    print( tmp );
                    continue;
                }
            } catch (NumberFormatException e) {

            }
            print(a);


        }
    }

    public static void print(Double value) {
        System.out.println( "Это тип Double, значение " + value );
    }

    public static void print(String value) {
        System.out.println( "Это тип String, значение " + value );
    }

    public static void print(short value) {
        System.out.println( "Это тип short, значение " + value );
    }

    public static void print(Integer value) {
        System.out.println( "Это тип Integer, значение " + value );
    }
}
