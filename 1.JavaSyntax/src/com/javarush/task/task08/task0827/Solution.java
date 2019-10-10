package com.javarush.task.task08.task0827;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датой
*/

public class Solution {
    public static void main (String[] args) {


        System.out.println( " JANUARY 2 2020 " + " = " + isDateOdd( "JANUARY 2 2020" ) );
    }

    public static boolean isDateOdd (String date) {
//        Locale locale = new Locale( "EN" );
//        Locale.setDefault( locale );

        Date date1 = new Date( date );
        Date start_year = new Date( date );
        start_year.setHours( 0 );
        start_year.setMinutes( 0 );
        start_year.setSeconds( 0 );
        start_year.setDate( 1 );
        start_year.setMonth( 0 );

        long d = date1.getTime() - start_year.getTime();
        long ms = 1000 * 60 * 60 * 24;
        int datCount = (int) (d / ms);
        if (datCount % 2 == 0)
            return true;

        else return false;
    }
}
