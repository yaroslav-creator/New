package com.javarush.task.task21.task2112;

public class Solution {
    public static void main(String[] args) {
        DBConnectionManager dbConnectionManager = new DBConnectionManager();

        try (FakeConnection fakeConnection = dbConnectionManager.getFakeConnection()) {
            System.out.println("Entering body of try block.");

            fakeConnection.usefulOperation();
            fakeConnection.unsupportedOperation();
        } catch (Exception e) {
        }
    }
}


/* Establishing database connection...  Установка подключения к базе данных...
Entering body of try block.             Вводится тело блока try
Executing useful operation.             Выполнение полезной операции.
Operation is not supported yet!         Операция пока не поддерживается!
Closing database connection             Закрытие соединения с базой данных
 */