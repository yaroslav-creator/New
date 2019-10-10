package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main (String[] args) throws Exception {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        int[] number = new int[10];     // создаем массив на 10 чисел
        String[] list = new String[10]; // создаем массив на 10 строк

        for (int i = 0; i < list.length; i++) {
            String s = reader.readLine();
            list[i] = s;           // ввести с клавиатуры 10 строк, заполнить им массив строк
        }


        for (int i = 0; i < number.length; i++) {
            number[i] = list[i].length();// В каждую ячейку массива чисел записать длину строки
                                           // из массива строк, индекс/номер ячейки которой,
                                            // совпадает с текущим индексом из массива чисел.

        }

        for (int i = 0; i < number.length; i++) {
            System.out.println( number[i] );     //Вывести содержимое массива чисел на экран,
                                                 // каждое значение выводить с новой строки.

        }
    }
}