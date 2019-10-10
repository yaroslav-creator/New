package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap <String, String> createMap () {
        //напишите тут ваш код
        HashMap <String, String> map = new HashMap <>();
        map.put( "Круз ", " Том" );
        map.put( "Дефо ", " Даниель " );
        map.put( "Чистов ", " Виталя " );
        map.put( "Табаков ", " Александр " );
        map.put( "Багров ", " Виталя " );
        map.put( "Исаев ", " Виталя " );
        map.put( "Листок ", " Глеб " );
        map.put( "Ершов ", " Андрей " );
        map.put( "Юдин ", "Денис " );
        map.put( "Цейс ", " Виталя " );

        return map;

    }

    public static void removeTheFirstNameDuplicates (Map <String, String> map) {
        //напишите тут ваш код
        HashMap <String, String> copy = new HashMap <String, String>( map );
        for (Map.Entry <String, String> s : copy.entrySet()) {
            for (Map.Entry <String, String> s2 : copy.entrySet()) {
                if (s.getValue().equals( s2.getValue() ) && !s.getKey().equals( s2.getKey() ))
                    removeItemFromMapByValue( map, s.getValue() );
            }
        }

    }

    public static void removeItemFromMapByValue (Map <String, String> map, String value) {
        HashMap <String, String> copy = new HashMap <String, String>( map );
        for (Map.Entry <String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals( value ))
                map.remove( pair.getKey() );
        }
    }

    public static void main (String[] args) {
        HashMap <String, String> map = createMap();
       // System.out.println( map );
        removeTheFirstNameDuplicates( map );
       // System.out.println( map );
    }
}
