package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fis = new FileInputStream( file1 );
        FileOutputStream fos = new FileOutputStream( file2 );

        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);

        for (int i = bytes.length -1; i >= 0; i--) {
            fos.write( bytes[i] );
        }
        fis.close();
        fos.close();
    }
}
