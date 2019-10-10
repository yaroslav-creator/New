package com.javarush.task.task05.task0528;

import java.util.*;
/* 
Вывести на экран сегодняшнюю дату
*/

import java.util.Calendar;

public class Solution {
    public static void main (String[] args) {


        Calendar c = Calendar.getInstance();
        int day = c.get( c.DAY_OF_MONTH );
        int month = c.get( c.MONTH ) + 1;
        int year = c.get( c.YEAR );
        System.out.println( day + " " + month + " " + year + " " );

    }
}
