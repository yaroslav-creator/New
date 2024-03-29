package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fileReader = new BufferedReader( new FileReader( fileName1 ) );
        BufferedWriter fileWriter = new BufferedWriter( new FileWriter( fileName2 ) );

        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String[] digital = s.split( "\\s" );

            for (String str : digital)
                try {
                    System.out.println( Integer.parseInt( str ) );
                    fileWriter.write( str + " " );
                } catch (NumberFormatException e) {
                    continue;
                }
        }

        fileWriter.close();
        fileReader.close();
    }
}
