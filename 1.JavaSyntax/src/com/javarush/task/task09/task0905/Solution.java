package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
        //напишите тут ваш код
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        System.out.println(stackTraceElement.length);
        return stackTraceElement.length;
    }
}

