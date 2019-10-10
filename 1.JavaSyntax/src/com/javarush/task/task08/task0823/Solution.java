package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String s = reader.readLine();

        //напишите тут ваш код

        char[] a = s.toCharArray(); // преобразует данную массив в новый массив символов.

        a[0] = Character.toUpperCase( a[0] ); // Первый элемент массива a[0] toUpperCase() возвращает элемент,
                                              // преобразованный в верхний регистр

        boolean b = false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == ' ') {

                b = true;

            } else if (a[i] != ' ' && b) {
                a[i] = Character.toUpperCase( a[i] );

                b = false;
            }
        }
        System.out.println( a );
    }
}
