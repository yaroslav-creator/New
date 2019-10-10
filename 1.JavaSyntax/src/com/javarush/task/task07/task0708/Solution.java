package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List <String> strings ;

    public static void main (String[] args) throws Exception {

        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        strings = new ArrayList <>();
        for (int i = 0; i < 5; i++) {
            strings.add( reader.readLine() );

        }

        int max = strings.get( 0 ).length();
        for (String s : strings)
            if (s.length() > max) {
                max = s.length();
            }

        for (String s : strings) {
            if (s.length() == max)
                System.out.println( s );

        }

    }
}
