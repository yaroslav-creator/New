package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream( fileName1 );
        FileOutputStream outputStream = new FileOutputStream( fileName2 );

        byte[] bytes = new byte[inputStream1.available()];
        inputStream1.read( bytes );

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            stringBuilder.append( (char) bytes[i] );
        }

        String[] doubles = stringBuilder.toString().split( " " );
        StringJoiner stringJoiner = new StringJoiner( " " );
        for (int i = 0; i < doubles.length; i++) {
            stringJoiner.add(String.valueOf(Math.round(Double.parseDouble(doubles[i]))));
        }

        outputStream.write( stringJoiner.toString().getBytes() );

        inputStream1.close();
        outputStream.close();
        reader.close();
    }
}