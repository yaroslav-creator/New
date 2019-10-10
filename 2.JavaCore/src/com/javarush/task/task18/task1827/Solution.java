package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String fileName = reader.readLine();
        reader.close();

        if (args.length != 0 && args[0].equals( "-c" )) {
            BufferedReader reader1 = new BufferedReader( new FileReader( fileName ) );

            int id;
            int max = 0;
            while (reader1.ready()) {
                id = Integer.parseInt( reader1.readLine().substring( 0, 8 ).trim() );
                if (id > max) max = id;
            }
            reader1.close();

            BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter( fileName,true ) );

            bufferedWriter.newLine(); // перенос на новую строку
            //Запись строки в новом формате
            bufferedWriter.write(String.format( "%-8s%-30s%-8s%-4s", max + 1, args[1],args[2],args[3]) );
            bufferedWriter.close();
        }
    }
}
