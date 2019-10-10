package com.javarush.task.task19.task1926;

/* 
Перевертыши

             C:\Users\Ярослав\Documents\task19.task1926read.txt
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(  new InputStreamReader( System.in ) );
        String fileName = reader.readLine();
        reader.close();

        BufferedReader bufferedReader = new BufferedReader( new FileReader( fileName ) );

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            StringBuffer buffer = new StringBuffer( line );
            System.out.println(buffer.reverse());
        }
        bufferedReader.close();

    }
}
