package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.


C:\Users\Ярослав\Documents\task.task19.task1924.txt

*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader
                ( new InputStreamReader( System.in ) ) ;

        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader fileReader = new BufferedReader( new FileReader( fileName ) );
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            for (Map.Entry<Integer, String> pair : map.entrySet())
                line = line.replaceAll("\\b" + pair.getKey().intValue() + "\\b",pair.getValue()  );
            System.out.println( line);
        }
            fileReader.close();
    }
}
