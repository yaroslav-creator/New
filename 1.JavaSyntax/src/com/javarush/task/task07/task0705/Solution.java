package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main (String[] args) throws Exception {
        int[] a = new int[20];
        int[] b = new int[10];
        int[] c = new int[10];
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt( reader.readLine() );

        }
        //            System.out.println( b[i] );
        for (int i = 0; i < b.length; i++) System.arraycopy( a, 0, b, 0, b.length );
        for (int i = 0; i < c.length; i++) {

            System.arraycopy( a, b.length, c, 0, c.length );
            System.out.println( c[i] );
        }
    }
}
