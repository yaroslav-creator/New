package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        List<Integer> integerList = getIntegerList();

        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум тут


        return Collections.min( array );
    }

    public static List<Integer> getIntegerList() throws IOException {
        // Создать и заполнить список тут
        ArrayList<Integer> list = new ArrayList <>(  );

        BufferedReader reader = new BufferedReader(
                new InputStreamReader( System.in ) );

        int n = Integer.parseInt( reader.readLine() );

        for (int i = 0; i < n; i++){
            list.add( Integer.parseInt( reader.readLine() ) );
        }

        return list;
    }
}
