package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
Файл1 содержит строки со словами, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры,
например, а1 или abc3d.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {


        BufferedReader fileReader = new BufferedReader( new FileReader
                ( "C:\\Users\\Ярослав\\Documents\\ReadFile.txt" ) );

        BufferedWriter printWriter = new BufferedWriter( new FileWriter
                ( "C:\\Users\\Ярослав\\Documents\\WriteInFile.txt",true ) );

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] words = line.split( " " );
            for (String word : words)
                if (!word.matches( "^\\D*$" ))
                    printWriter.write( word + " " );
        }
        fileReader.close();
        printWriter.close();
    }
}
