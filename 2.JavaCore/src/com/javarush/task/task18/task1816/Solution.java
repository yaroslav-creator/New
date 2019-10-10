package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, FileNotFoundException {

      //  args = new String[]{"C:\\Users\\Ярослав\\Documents\\ReadFile.txt"};

        FileInputStream inputStream = new FileInputStream(args[0]);
        int count=0;

        while (inputStream.available() > 0) {
            int temp = inputStream.read();
            if ((temp >= 65 && temp <= 90) || (temp >= 97 && temp <= 122)) {
                count++;
            }
        }
        System.out.println(count);
        inputStream.close();
    }
}