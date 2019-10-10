package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(fileName1);
        byte[] bytes1 = new byte[inputStream1.available()];
        inputStream1.read( bytes1 );


        FileInputStream inputStream2 = new FileInputStream( fileName2 );
        byte[] bytes2 = new byte[inputStream2.available()];
        inputStream2.read( bytes2 );

        FileOutputStream outputStream = new FileOutputStream( fileName1 );
        outputStream.write( bytes2 );
        outputStream.write( bytes1 );

        inputStream1.close();
        inputStream2.close();
        outputStream.close();

    }
}
