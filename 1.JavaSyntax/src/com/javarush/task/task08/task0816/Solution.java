package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        map.put( "Rocky", df.parse( "JULY 11 1980" ) );
        map.put( "Sem", df.parse( "SEPTEMBER 15 1980" ) );
        map.put( "Peat", df.parse( "MAY 1 1980" ) );
        map.put( "Angel", df.parse( "AUGUST 1 1980" ) );
        map.put( "Andrea", df.parse( "DECEMBER 1 1980" ) );
        map.put( "Cries", df.parse( "OCTOBER 1 1980" ) );
        map.put( "Lana", df.parse( "NOVEMBER 1 1980" ) );
        map.put( "Bob", df.parse( "JUNE 1 1980" ) );
        map.put( "Glen", df.parse( "AUGUST 1 1980" ) );

        return map;

        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String,Date>> iterator = map.entrySet().iterator();

        while(iterator.hasNext())
        {
            Map.Entry<String,Date> pair = iterator.next();
            Date value = pair.getValue();
            int summer = value.getMonth();
            if(summer == 5 || summer == 6 || summer == 7)
                iterator.remove();
        }
    }




    public static void main(String[] args) {

    }
}
