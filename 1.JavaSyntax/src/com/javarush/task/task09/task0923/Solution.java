package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in) );
         String s2 = reader.readLine();
         String s = s2.replaceAll(" ","");
        ArrayList<Character> glass =new ArrayList<>();
        ArrayList<Character> soglass = new ArrayList<>();

        for (int i =0; i < s.length(); i++){
            if (isVowel(s.charAt(i))) {
                glass.add(s.charAt(i));
            }else {
                soglass.add(s.charAt(i));
            }
        }
        for (Character c : glass) System.out.print(c + " ");
        System.out.println();
        for (Character c : soglass) System.out.print(c + " ");
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}