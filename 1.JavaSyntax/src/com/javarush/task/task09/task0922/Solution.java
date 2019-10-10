package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));// считываем с клавиатуры

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//устанавливаем формат считывания даты
        Date date = format.parse(reader.readLine());  // дата равна читаем с клавиатуры

        SimpleDateFormat format1 = new SimpleDateFormat("MMM dd, yyyy",Locale.ENGLISH);// устанавливаем нов.формат даты
        System.out.println(format1.format(date).toUpperCase());// выводим дату в верхнем регистре
    }
}
