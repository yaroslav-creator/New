package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap <>(  );
        map.put( "Круз ", 900 );
        map.put( "Дефо ", 800 );
        map.put( "Чистов ", 700 );
        map.put( "Табаков ", 400 );
        map.put( "Багров ", 300 );
        map.put( "Исаев ", 500 );
        map.put( "Листок ", 200 );
        map.put( "Ершов ", 600 );
        map.put( "Юдин ", 300 );
        map.put( "Цейс ", 100 );
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap <String, Integer> copy = new HashMap <String, Integer>(map);
        for (Map.Entry <String, Integer> pair : copy.entrySet())
            if (pair.getValue() < 500) {
                map.remove( pair.getKey() );
            }
    }
    public static void main(String[] args) {
//        HashMap <String, Integer> map = createMap();
//        System.out.println( map );
//         removeItemFromMap(map );
//        System.out.println(map);
    }
}