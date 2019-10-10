package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {


    public static void main(String[] args) throws IOException {

       //args = new String[]{"C:\Users\Ярослав\Documents\noBOMNotepad.txt"};


        BufferedReader reader = new BufferedReader( new FileReader( args[0] ) ) ;
            TreeMap<String, Double> map = new TreeMap<>(  );

            String line;
            double wages;

        while ((line = reader.readLine()) != null) {
            String[] name = line.split( " " );
             wages = Double.parseDouble( name[1] );
//            System.out.println(name[0]);
            if (map.containsKey( name[0] )) {
                map.put( name[0],map.get( name[0] ) + wages );

            }else {
                map.put( name[0], wages );
            }
        }
        map.forEach( (k, v) -> System.out.println(k + " " + v) );

        reader.close();
    }
}