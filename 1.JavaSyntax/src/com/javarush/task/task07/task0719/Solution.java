package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        //напишите тут ваш код

        ArrayList <Integer> list = new ArrayList <>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add( Integer.parseInt( s ) );


        }
        for (int i = 0; i < list.size(); i++) {

            int j = list.size() - i - 1;
            System.out.println(list.get( j ));
        }
    }
}