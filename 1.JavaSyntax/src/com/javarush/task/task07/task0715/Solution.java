package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList <>( );

        list.add( "мама" ); // создаем список из слов
        list.add( "мыла" );
        list.add( "раму" );

        list.add( 1, "именно" );// добавляем строку сод.слово именно
        list.add( 3, "именно" );// после каждого слова
        list.add( 5, "именно" );// после каждого слова

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get( i ));
        }
    }
}
