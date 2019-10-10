package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(
                new BufferedReader( new InputStreamReader( System.in ) ).readLine() )){

            //Класс TreeSet создаёт коллекцию, которая для хранения элементов использует дерево.
            // Объекты хранятся в отсортированном порядке по возрастанию.

            TreeSet<Integer> treeSet = new TreeSet<>(  );

            while (fileInputStream.available() > 0) {
                treeSet.add( fileInputStream.read() );
            }

            for (Integer sort : treeSet) {
                System.out.print(sort + " ");
            }
        }
    }
}
