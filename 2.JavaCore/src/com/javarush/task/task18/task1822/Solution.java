package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException, ArrayIndexOutOfBoundsException {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = consoleReader.readLine();
        consoleReader.close();

        int id = Integer.parseInt(args[0]);

        FileInputStream inputStream = new FileInputStream(filename); //считываю байты
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String productName = "";
        double price;
        int quantity;

        while (true)
        {
            String line = reader.readLine();  //считываю файл построчно
            if (line == null) break;
            String[] array = line.split(" ");  //разделяю строку на массив строк
            if (Integer.parseInt(array[0]) == id) {
                for (int i = 1; i < (array.length - 2); i ++) {
                    productName = productName + array[i];
                }
                price = Double.parseDouble(array[array.length - 2]);
                quantity = Integer.parseInt(array[array.length - 1]);
                System.out.println(id + " " + productName + " " + price + " " + quantity);
            }
        }
        reader.close();
        inputStream.close();
    }
}
