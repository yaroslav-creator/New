package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {

    public static void main(String[] args) {

        try{divisionByZero();}  //Метод main должен отлавливать любые исключения метода divisionByZero.
        catch (Exception e){  // Оберни вызов метода divisionByZero в try..catch.

            e.printStackTrace();    //выводим стек-трейс исключения использую метод exception.printStackTrace()
        }
    }
    public static void divisionByZero() {
        int result = 30/0;       //Метод divisionByZero должен содержать операцию деления любого числа на ноль.
        System.out.println(result);  // Метод divisionByZero должен вызывать System.out.println или System.out.print.
    }
}
