package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main (String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        BufferedReader reader = new BufferedReader(
                new InputStreamReader( System.in ) );

        ArrayList <String> list = new ArrayList <>();
        for (int i = 0; i < 10; i++) {
            list.add( reader.readLine() );
        }

        ArrayList <String> result = doubleValues( list );
        for (String s : result)
            // Вывести на экран result
        System.out.println( s );
    }


    public static ArrayList <String> doubleValues (ArrayList <String> list) {

        for (int i = 0; i < list.size(); i++) {

            list.add( i + 1, list.get( i ) );// удваиваем элементы по принципу
            i++;                             //альфа,альфа,бета,бета,гамма,гамма
        }

        return (list);
    }
}
