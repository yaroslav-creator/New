package com.javarush.task.task32.task3210;

/*
Используем RandomAccessFile

1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        long number = Long.parseLong( args[1] );
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile( fileName, "rw" );

        byte[] bytes = new byte[text.length()];
        raf.seek( number );
        raf.read( bytes, 0, bytes.length );

        raf.seek( raf.length() );

        if (text.equals( new String( bytes ) )){
            raf.write( "true".getBytes() );
        }else {
            raf.write( "false".getBytes() );
        }
        raf.close();
    }
}
