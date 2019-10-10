package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println( getRadix( "112" ) );        //expected output: [3, 27, 13, 15]
        System.out.println( getRadix( "123" ) );        //expected output: [6]
        System.out.println( getRadix( "5321" ) );       //expected output: []
        System.out.println( getRadix( "1A" ) );         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {

        Set<Integer> setRadix = new HashSet<>();
        try {
            int i = Integer.parseInt( number );

            for (int radix = 2; radix <= 36; radix++) {

                String s = Integer.toString( i, radix );

                //Для наименьших строк кода и простейшего случая
                if (s.equals( new StringBuilder( s ).reverse().toString() ))
                    setRadix.add( radix );
            }
        }catch (NumberFormatException e) {

        }
        return setRadix;
    }

}