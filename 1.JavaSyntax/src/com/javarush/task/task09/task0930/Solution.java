package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> str = new ArrayList<>();
        for (String x : array) {
            if (isNumber(x)) {
                int n = Integer.parseInt(x);
                list.add(n);


            } else str.add(x);

        }

        for (int i = 1; i < str.size(); i++) {
            for (int j = 1; j < str.size() - i + 1; j++) {
                if (isGreaterThan(str.get(j - 1), str.get(j))) {
                    String tmp = str.get(j - 1);
                    str.set(j - 1, str.get(j));
                    str.set(j, tmp);
                }
            }
        }

        Collections.sort(list, Comparator.reverseOrder());
        int n = 0, j = 0;
        for (int i = 0; i < array.length; i++ ){
            if (isNumber(array[i])){
                array[i] = list.get(n).toString();
                n++;
            }
            else{ array[i] = str.get(j);
                j++;}
        }

    }




    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
