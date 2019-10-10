package com.javarush.task.task03.task0312;

/* 
Конвертируем время
*/

public class Solution {
    public static int convertToSeconds(int hour){

        int s = hour * 3600;
        return (s);
    }

    public static void main(String[] args) {
        System.out.println(convertToSeconds(2));
        System.out.println(convertToSeconds(5));
    }


}
