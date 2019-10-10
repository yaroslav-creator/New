package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        ArrayList<int[]> list = new ArrayList<>();
        int[] i5 = {1,2,3,4,5};
        int[] i2 = {1,2};
        int[] i4 = {1,2,3,4};
        int[] i7 = {1,2,3,4,5,6,7};
        int[] i0 = {};
        list.add(i5);
        list.add(i2);
        list.add(i4);
        list.add(i7);
        list.add(i0);
        return list;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
