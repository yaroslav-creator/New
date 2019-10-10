package com.javarush.task.task08.task0808;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* 
10 тысяч удалений и вставок
*/

public class Solution {
    public static void main (String[] args) throws Exception {
        // ArrayList
        ArrayList arrayList = new ArrayList();
        insert10000( arrayList );
        get10000( arrayList );
        set10000( arrayList );
        remove10000( arrayList );

        // LinkedList
        LinkedList linkedList = new LinkedList();
        insert10000( linkedList );
        get10000( linkedList );
        set10000( linkedList );
        remove10000( linkedList );


    }

    public static void insert10000 (List list) {
        //напишите тут ваш код
        //Метод insert10000(List list)  вставляет 10 тысяч элементов в список.

        for (int i = 0; i < 10000; i++) {
            list.add( i );

        }

    }

    public static void get10000 (List list) {
        //напишите тут ваш код
        //Метод get10000(List list)  вызывает 10 тысяч раз get у списка.

        for (int i = 0; i < 10000; i++) {
            list.get( i );

        }

    }

    public static void set10000 (List list) {
        //напишите тут ваш код
        //Метод set10000(List list)  вызывает 10 тысяч раз set у списка.

        for (int i = 0; i < 10000; i++) {
            list.set( i, "s" );

        }

    }

    public static void remove10000 (List list) {
        //напишите тут ваш код
        //Метод remove10000(List list)  удаляет 10 тысяч элементов из списка.

        for (int i = list.size() - 1; i >= 0; i--) {
            list.remove( i );

        }


    }

}
