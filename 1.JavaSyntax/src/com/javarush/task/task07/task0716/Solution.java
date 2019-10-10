package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main (String[] args) throws Exception {
        ArrayList <String> list = new ArrayList <String>();
        list.add( "роза" ); // 0
        list.add( "лоза" ); // 1
        list.add( "лира" ); // 2
        //       list.add( "вилор" ); // 2
//        list.add( "мера" ); // 2
//        list.add( "упор" ); // 2
//        list.add( "лена" ); // 2

        list = fix( list );

        for (String s : list) {
            System.out.println( s );
        }
    }

    public static ArrayList <String> fix (ArrayList <String> list) {
        //напишите тут ваш код

        //Delete word contain "р"
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get( i ).contains( "р" ) && !list.get( i ).contains( "л" ))
                list.remove( list.get( i ) );
        }
        // word with "р" and "л" do not change anything
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get( i ).contains( "р" ) && list.get( i ).contains( "л" ))
                continue;

        }
        //Duplicate word with "л"
        for (int i = list.size() - 1; i >= 0; i--) {
            if (!list.get( i ).contains( "р" ) && list.get( i ).contains( "л" )) {
                list.add( i, list.get( i ) );
            }


        }

        return list;
    }
}