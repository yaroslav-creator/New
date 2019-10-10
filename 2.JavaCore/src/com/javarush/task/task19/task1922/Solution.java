package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add( "файл" );
        words.add( "вид" );
        words.add( "В" );
    }

    public static void main(String[] args) throws IOException {

        //C:\Users\Ярослав\Documents\someFile 1.txt

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(reader.readLine())) {
            BufferedReader fReader = new BufferedReader(fileReader);


            String line;
            while ((line = fReader.readLine()) != null) {
                String[] splitString = line.replaceAll("[\\p{Punct}+]", "").split(" ");
                List<String> list = new LinkedList<>(Arrays.asList(splitString));
                list.retainAll(words);
                if (list.size() == 2) {
                    System.out.println(line);
                    //System.out.println(words);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
