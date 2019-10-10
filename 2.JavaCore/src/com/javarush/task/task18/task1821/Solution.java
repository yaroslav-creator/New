package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        //args = new String[]{"C:\\Users\\Ярослав\\Documents\\someFile.txt"};


        FileInputStream inputStream = new FileInputStream( args[0] );
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        while (inputStream.available() > 0) {
            int bytes = inputStream.read();

            if (treeMap.containsKey( bytes )) {
                treeMap.put( bytes, (treeMap.get( bytes ) + 1) );
            } else {
                treeMap.put( bytes, 1 );
            }
        }

        for (Map.Entry<Integer, Integer> map : treeMap.entrySet()) {
            char ch = (char) Integer.parseInt( map.getKey().toString() );
            System.out.println( ch + " " + map.getValue() );
        }
        inputStream.close();
    }
}
