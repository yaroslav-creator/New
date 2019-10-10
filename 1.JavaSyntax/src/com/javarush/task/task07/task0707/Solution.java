package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main (String[] args) throws Exception {
        ArrayList <String> list = new ArrayList <>();

        list.add( "Первый" );
        list.add( "раз" );
        list.add( "в" );
        list.add( "первый" );
        list.add( "класс !" );

        System.out.println( Integer.valueOf( list.size() ) );

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get( i ));
        }


    }
}
