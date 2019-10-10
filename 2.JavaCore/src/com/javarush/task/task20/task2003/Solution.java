package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap()  {
        //implement this method - реализуйте этот метод
        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader(System.in)); // считываем данные с консоли

             //создаем новый FIS передаем считанную строку в качестве параметра
             FileInputStream fis = new FileInputStream(reader.readLine())) {

            load(fis);                //вызываем метод load передавая только что созданный FIS в качестве параметра.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод

        Properties properties1 = new Properties(  );      // создаем новые свойства
        properties1.putAll( properties );                 // сохраняем карту properties в полученный в
        properties1.store( outputStream, "" );  // качестве параметра объект типа OutputStream.
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties(  );

        prop.load( inputStream );//восстанавливаем(загружаем) состояние карты properties
                                 // из полученного в качестве параметра объекта типа InputStream.

        //заполняем карту properties данными из файла.
        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
            properties.put( (String)entry.getKey(), (String)entry.getValue() );
        }
    }

    public static void main(String[] args) {

    }
}
