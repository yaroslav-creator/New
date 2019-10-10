package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона

Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null) return false;
        if (telNumber.isEmpty()) return false;

        int isDigits = telNumber.replaceAll("\\D", "").length();

        if ((telNumber.charAt(0) == '+' && isDigits == 12) || (telNumber.charAt(0) != '+' && isDigits == 10)) {

            return telNumber.matches("(\\+\\d+)?\\d*(\\(\\d{3}\\))?\\d+(-?\\d+){0,2}");
        }
        else return false;
    }


    public static void main(String[] args) {


        String[] s = {
                "",
                "+380501234567",
                "+38(050)1234567",
                "+38050123-45-67",
                "050123-4567",
                "+38)050(1234567",
                "+38(050)1-23-45-6-7",
                "050ххх4567",
                "0501236",
                "(0)501234567",
                "+38(050)1-23-45--6-7",
                "+3-8(050)1-23-45--6-7",
                "+38050123-4567-"
        };

        for (String t : s) System.out.printf("%25s :   %5s %n",t,checkTelNumber(t));
    }
}
