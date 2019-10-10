package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        args = new String[3];
        args[0] = "00";
        args[1] = "12AS08z";
        args[2] = "12AS08Z/";

        boolean checkNotation = false;
        for (int i = 2; i < 37; i++) {
            try {
                new BigDecimal( new BigInteger( args[0], i ) );
                System.out.println(i);
                checkNotation = true;
                break;
            }catch (Exception ignored) {

            }
        }
        if (!checkNotation)
            System.out.println("incorrect");
    }
}

/*
Пример1:
Вход:
00
Ожидаемый вывод:
2

Пример2:
Вход:
12AS08z
Ожидаемый вывод:
36

Пример3:
Вход:
12AS08Z/
Ожидаемый вывод:
incorrect*/