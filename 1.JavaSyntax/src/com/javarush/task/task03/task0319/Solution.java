package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        {
            InputStream inputStream = System.in;
            Reader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


            String name = bufferedReader.readLine();
            String sAge = bufferedReader.readLine();
            String sAge1 = bufferedReader.readLine();
             int nAge = Integer.parseInt(sAge);
             int nAge1 = Integer.parseInt(sAge1);
            System.out.println(name + " получает " + nAge + " через " + nAge1 + " лет.");//напишите тут ваш код
        }//напишите тут ваш код
    }
}
