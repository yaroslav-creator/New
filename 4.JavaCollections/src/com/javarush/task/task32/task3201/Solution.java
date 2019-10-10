package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл

1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.
*/
public class Solution {
    public static void main(String... args) throws IOException {

        String fileName = args[0];
        long number = Long.parseLong( args[1] );
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile( fileName, "rw" );

        if (number > raf.length())
            number = raf.length();

        raf.seek( number );
        raf.write( text.getBytes() );
        raf.close();
    }
}
