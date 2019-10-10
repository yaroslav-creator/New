package com.javarush.task.task19.task1920;

/* 
Самый богатый
Петров 0.501
Иванов 1.35
Петров 0.85
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader( args[0] ) );
        TreeMap<String, Double> map = new TreeMap<>();

        String line;
        double wages;

        while ((line = reader.readLine()) != null) {
            String[] name = line.split( " " );
            wages = Double.parseDouble( name[1] );

            if (map.containsKey( name[0] )) {
                map.put( name[0], map.get( name[0] ) + wages );
            } else {
                map.put( name[0], wages );
            }
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue().equals( Collections.max( map.values() ) )) {
                System.out.println( entry.getKey() );
                reader.close();
            }
        }
    }
}
