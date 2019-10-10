   package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

   import java.io.FileInputStream;
   import java.io.IOException;

   public class Solution {
    public static void main(String[] args) throws IOException {

         // args = new String[]{"C:\\Users\\Ярослав\\Documents\\ReadFile.txt"};
        FileInputStream inputStream = new FileInputStream( args[0] );

        int count = 0;
        int sum = inputStream.available();

        while (inputStream.available() > 0) {
            int i = inputStream.read();
            if (i == 32)
                count++;
        }
        inputStream.close();
        double result = (double) count/ sum * 100;
        System.out.printf("%.2f", result);
    }
}
