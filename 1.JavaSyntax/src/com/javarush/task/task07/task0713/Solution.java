package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main (String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(
                new InputStreamReader( System.in ) );

        ArrayList <Integer> list = new ArrayList <>();
        ArrayList <Integer> list3 = new ArrayList <>();// делятся на 3
        ArrayList <Integer> list2 = new ArrayList <>();// делятся на 2
        ArrayList <Integer> listlost = new ArrayList <>();// остальные

        for (int i = 0; i < 20; i++) {
            list.add( Integer.parseInt( reader.readLine() ) );

            if (list.get( i ) % 3 == 0 && list.get( i ) % 2 == 0) {
                list3.add( list.get( i ) );
                list2.add( list.get( i ) );

            } else if (list.get( i ) % 3 == 0) {
                list3.add( list.get( i ) );

            } else if (list.get( i ) % 2 == 0) {
                list2.add( list.get( i ) );

            } else {
                listlost.add( list.get( i ) );

            }
        }
        printList( list3 );
        printList( list2 );
        printList( listlost );
        printList( list );
    }

    public static void printList (List <Integer> list) {
        //напишите тут ваш код
        // for (int i = 0; i < list.size(); i++) { // неправильный вывод данных
        // выводятся индексы чисел, а не числа !!!!!!
        for (Integer i : list)
            System.out.println( i );
    }
}
