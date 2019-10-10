package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );

    //- для вывода message в консоль
    public static void writeMessage(String message) {
        System.out.println( message );
    }

    // - для чтения строки с консоли
    public static String readString() throws IOException{
        String string = bufferedReader.readLine();
        return string;
    }

    //просит пользователя выбрать блюдо и добавляет его в список.
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> resultList = new ArrayList<>();

        writeMessage( "Our dishes:" );
        writeMessage( Dish.allDishesToString() );
        writeMessage( "==============================================" );
        writeMessage( "Enter dish name" );

        String enteredString = readString();
        boolean isNotADish = true;

        while (!enteredString.equals( "exit" )) {
            for (Dish dish : Dish.values()) {
                if (dish.toString().toLowerCase().equals( enteredString.toLowerCase() )) {
                    resultList.add( dish );
                    isNotADish = false;
                    break;
                } else {
                    isNotADish = true;
                }
            }
            if (isNotADish) {
                writeMessage( "There is no such dish on the menu." );
            }
            enteredString = readString();
        }
        return resultList;
    }
}