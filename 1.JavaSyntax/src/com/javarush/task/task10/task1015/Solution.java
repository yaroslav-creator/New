package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList( arrayOfStringList );
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код

        // //Массив списков типа Стринг равно создать массив списков на 3 элемента
        ArrayList<String>[] lists = new ArrayList[3];

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list1.add( "asd" );
            list2.add( "asdf" );
            list3.add( "fdggh" );
        }
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;
        return lists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println( s );
            }
        }
    }
}