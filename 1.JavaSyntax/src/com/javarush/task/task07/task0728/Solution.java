package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
В убывающем порядке
*/

public class Solution {


    public static void main (String[] args) throws Exception {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt( reader.readLine() );
        }

        sort( array );

        for (int x : array) {
            System.out.println( x );
        }
    }

    public static void sort (int[] array) {
        //напишите тут ваш код
        int buf;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] > array[j]) {         // сортировка по убыванию
             //  if (array[i] < array[j])          // сортировка по возрастанию
                    buf = array[j];
                    array[j] = array[i];
                    array[i] = buf;
                }
            }
        }
    }
}



