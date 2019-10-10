package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
/*
Хуан Хуанович
В метод main первым параметром приходит имя файла.В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013

*/


public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        //args = new String[]{"C:\Users\Ярослав\Documents\someFile 1.txt"};

        String fileName = args[0];

        try (BufferedReader fileReader = new BufferedReader( new FileReader( fileName ) )) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                String nameStr = line.replaceAll( "[\\w]", "" ).trim();
                String[] digitalParts = line.substring( nameStr.length() ).trim().split( " " );
                int day = Integer.parseInt( digitalParts[0] );
                int month = Integer.parseInt( digitalParts[1] );
                int year = Integer.parseInt( digitalParts[2] );
                Date date = new GregorianCalendar( year, month - 1, day ).getTime();

                PEOPLE.add( new Person( nameStr, date ) );

            }
        }
    }
}