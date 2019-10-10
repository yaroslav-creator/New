package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println( getPartOfString( "JavaRush - лучший сервис обучения Java." ) );
    }

    public static String getPartOfString(String string) {
        if (string == null ) {
            throw new TooShortStringException();
        }

        String array[] = string.split( " " );
        StringBuffer strBuffer = new StringBuffer();

        if (array.length >= 5) {
            for (int i = 1; i < 5; i++) {
                strBuffer.append( array[i] );
                strBuffer.append( " " );
            }
        } else {
            throw new TooShortStringException();
        }
        return strBuffer.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
