package com.javarush.task.task36.task3602;

import java.util.Collections;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println( getExpectedClass() );
    }

    public static Class getExpectedClass() {

        //get Classes
        for (Class clazz : Collections.class.getDeclaredClasses()) {

            //get interfaces
            for (Class inter : clazz.getInterfaces()) {

                if (inter.getSimpleName().equals( "List" )) {

                    //Gets the signers of this class.
                    clazz.getModifiers();
                }
            }
        }

        try {
            return Class.forName( "java.util.Collections$EmptyList" );

        }catch (ClassNotFoundException e){
            e.printStackTrace(  );
        }
        return null;
    }
}
