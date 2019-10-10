package com.javarush.task.task22.task2208;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put( "name", "Ivanov" );
        map.put( "country", "Ukraine" );
        map.put( "city", "Kiev" );
        map.put( "age", null );


        System.out.println( getQuery( map ) );

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            //В результат не должны входить пары содержащие: пустые ключ или пустые значения
            if (value != null && key != null)
                builder.append( key + " = '" + value + "' and " );
        }
        //делаем проверку, узнаем длинну builder и удаляем последнее лишнее " and " уменьшая длину строки на 5
        if (builder.length() > 0)
            return builder.substring( 0, builder.length() - 5 );
        else
            return builder.toString();
    }
}
