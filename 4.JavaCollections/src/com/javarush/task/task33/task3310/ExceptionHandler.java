package com.javarush.task.task33.task3310;

public class ExceptionHandler {

    //Статич. метод, который будет выводить краткое описание исключения.
    public static void log(Exception e){
        System.out.println(e.toString());
    }
}
