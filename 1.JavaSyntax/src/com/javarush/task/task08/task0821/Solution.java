package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap <String, String> map = new HashMap <>();
        map.put( "Круз ", " Том" );
        map.put( "Дефо ", " Даниель " );
        map.put( "Чистов ", " Виталя " );
        map.put( "Табаков ", " Александр " );
        map.put( "Багров ", " Андрей " );
        map.put( "Исаев ", " Виталя " );
        map.put( "Ершов ", " Глеб " );
        map.put( "Ершов ", " Андрей " );
        map.put( "Юдин ", "Денис " );
        map.put( "Табаков ", " Виталя " );

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
