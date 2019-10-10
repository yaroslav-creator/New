package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки

                                  Найдите медиану выборки 13 12 10 12 10 14 13 10
Для начала нужно расположить числа в порядке возрастания: 10 10 10 12 12 13 13 14.

Медиана - это число, которое посередине находится в этом ряду, но так как количество чисел четное,
то медиана равна среднему арифметическому двух числе посередине: (12+12)\2 = 12. 

*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] mass = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(Arrays.toString(sort(mass)));

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort( array );
        int len = array.length;
        int mediana;

        mediana = len % 2 != 0 ? array[len / 2] : (int) ((array[len / 2] + array[len / 2 - 1]) / 2);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs( o1 - mediana ) - Math.abs( o2 - mediana );
            }
        };

        ArrayList<Integer> list = new ArrayList<>( Arrays.asList( array ) );

        Collections.sort( list, comparator );
        Integer[] result = list.toArray( new Integer[list.size()] );
        return result;
    }
}
