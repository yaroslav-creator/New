package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        TreeSet<Character> characters = new TreeSet<>(  );

//        args[0] = "C:\\Users\\Ярослав\\Desktop\\3605_1.txt";
//        args[1] = "C:\\Users\\Ярослав\\Desktop\\3605_2.txt";

        try(BufferedReader fileReader = new BufferedReader( new FileReader( args[0] ) )){
            while (fileReader.ready()) {
                String s = fileReader.readLine().toLowerCase()
                        .replaceAll( "[^\\p{Alpha}]", "" );
                for (int i = 0; i < s.length(); i++){
                    characters.add( s.charAt( i ) );
                }
            }
        }

        Iterator<Character> iterator = characters.iterator();
        int n = characters.size() < 5 ? characters.size() : 5;

        for (int i = 0; i < n; i++) {
            System.out.print(iterator.next());
        }
    }
}

/**
 * 1 Вход: zBk yaz b-kN --- Вывод:  abkny
 * 2 Вход: caAC
 *         A, aB? bB    --- Вывод:  abc
 *
 * */