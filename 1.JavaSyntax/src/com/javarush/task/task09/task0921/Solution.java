package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList <>(  ); // создаем лист массива
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) ); // считываем с клав-ры
        while (true)
            try {
            String s = reader.readLine();  // читаем строку
            Integer i = Integer.parseInt( s ); // Integer перевод в int
            list.add( i );                    // добавляем в лист

        } catch (NumberFormatException e){  // ловить исключения числа
            e.printStackTrace();
            for (Integer number : list) System.out.println(number);
            break;
        }
        catch (IOException e){            //ловить исключения буквы
            e.printStackTrace();         // вывести стек-трейс
        }
    }
}
