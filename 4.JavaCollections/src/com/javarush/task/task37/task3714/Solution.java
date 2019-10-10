package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Древний Рим
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        StringBuffer buffer = new StringBuffer(s.trim());

        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(3000, "MMM");
        map.put(2000, "MM");
        map.put(900, "CM");
        map.put(1000, "M");
        map.put(800, "DCCC");
        map.put(700, "DCC");
        map.put(600, "DC");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(300, "CCC");
        map.put(200, "CC");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(80, "LXXX");
        map.put(70, "LXX");
        map.put(60, "LX");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(30, "XXX");
        map.put(20, "XX");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(8, "VIII");
        map.put(7, "VII");
        map.put(6, "VI");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(3, "III");
        map.put(2, "II");
        map.put(1, "I");

        int sum = 0;
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            int position = buffer.indexOf(pair.getValue());
            if (position >= 0) {
                sum += pair.getKey();
                buffer.delete(position, position + pair.getValue().length());
            }
        }
        return sum;
    }
}
