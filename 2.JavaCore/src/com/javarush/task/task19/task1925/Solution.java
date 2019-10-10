package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.nio.Buffer;

public class Solution {
    public static void main(String[] args) throws IOException {

        // String fileName1 = args[0];//"C:\\Users\\Ярослав\\Documents\\task19.task1925read.txt"
        // String fileName2 = args[1];//"C:\\Users\\Ярослав\\Documents\\task19.task1925write.txt"

        BufferedReader fileReader = new BufferedReader( new FileReader
                ( "C:\\Users\\Ярослав\\Documents\\task19.task1925read.txt" ) );
        FileWriter fileWriter = new FileWriter( "C:\\Users\\Ярослав\\Documents\\task19.task1925write.txt" );

        StringBuffer stringBuffer = new StringBuffer( "" );

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] words = line.split( " " );
            for (String word : words) {
                if (word.length() > 6) {
                    stringBuffer.append( word ).append( "," );
                }
            }
        }
        stringBuffer.delete( stringBuffer.length() - 1, stringBuffer.length() );
        fileWriter.write( stringBuffer.toString() );
        fileWriter.close();
        fileReader.close();
    }
}


