package com.javarush.task.task13.task1319;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(reader.readLine()));

        String str;
        do  {
            str = reader.readLine();
            writer.write(str);
            writer.newLine();

        } while (!str.equals("exit"));

        writer.close();
        reader.close();
    }
}
