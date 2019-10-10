package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileOutputStream outputStream1 = new FileOutputStream( fileName1,true );
        FileInputStream inputStream2 = new FileInputStream( fileName2 );
        FileInputStream inputStream3 = new FileInputStream( fileName3 );

        byte[] bytes2 = new byte[inputStream2.available()];
        byte[] bytes3 = new byte[inputStream3.available()];

        inputStream2.read( bytes2 );//Прочитали 2 поток
        inputStream3.read( bytes3 );//Прочитали 3 поток

        outputStream1.write( bytes2 );//Записать в первый файл содержимого 2 файла,
        outputStream1.write( bytes3 );//а потом дописать в 1 файл содержимое 3 файла


        outputStream1.close();// Закрыли 1 поток
        inputStream2.close();// Закрыли 2 поток
        inputStream3.close();// Закрыли 3 поток
    }
}
