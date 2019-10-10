package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        String s = null;
        while (true) {
            s = reader.readLine();
            if (s.equals( "exit" ))
                break;

            ReadThread readThread = new ReadThread(s);
            readThread.start();
        }

    }

    public static class ReadThread extends Thread {

         String fileName = null;
         ArrayList<Integer> list = new ArrayList<>(  );

        public ReadThread(String fileName) throws IOException {
            //implement constructor body
            this.fileName = fileName;

            FileInputStream inputStream= new FileInputStream( fileName );
            while (inputStream.available() > 0)
                list.add(inputStream.read());
                inputStream.close();
        }

        @Override
        public void run() {

            int element = list.get( 0 );
            for (Integer x : list)
                if ((Collections.frequency( list, x )) > Collections.frequency( list, element ))
                    element = x;
            resultMap.put( fileName, element );
        }

        // implement file reading here - реализуйте чтение из файла тут
    }
}
