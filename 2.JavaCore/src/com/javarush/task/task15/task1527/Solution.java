package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String s = br.readLine();
            String[] words1 = s.split("\\?");
            String[] words2 = words1[1].split("&");
            for (String st : words2 ) {
                String[] words3 = st.split("=.+");
                System.out.println(words3[0]);//add your code here
            }

            for (String st2 : words2) {
                if (st2.replaceAll("=.*$", "").contains("obj")) {
                    try {
                        alert(Double.parseDouble(st2=st2.replaceAll("^[^=]*=", "")));
                    } catch (NumberFormatException e) {
                        alert(st2);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

}
