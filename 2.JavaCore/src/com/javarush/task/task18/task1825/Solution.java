package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String outputFile = "";

        ArrayList<String> fileList = new ArrayList<>();
        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals( "end" )) {
                break;
            }
            fileList.add( fileName );
            outputFile = fileName.substring( 0, fileName.indexOf( ".part" ) );
        }

        Collections.sort( fileList );         //сортировка имен частей

        FileOutputStream outputStream = new FileOutputStream( outputFile, true );

        for (String s : fileList) {
            BufferedReader reader1 = new BufferedReader( new FileReader( s ) );
            while (reader1.ready()) {
                int data = reader1.read();
                outputStream.write( data );
            }
            reader1.close();
        }
        reader.close();
        outputStream.close();
        //System.out.println(outputStream);
    }

}
