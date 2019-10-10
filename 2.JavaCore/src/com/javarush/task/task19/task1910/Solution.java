package com.javarush.task.task19.task1910;

/* 
Пунктуация
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
            fileWriter.write( s.replaceAll("\\p{Punct}",""  )) ;
        }
        fileWriter.close();
        fileReader.close();
    }
}

/*   [\\p{P}\n] означает?

*  \p{P} - любой знак пунктуации
      \n - новая строка
     [ ] - любое из
     \s - space (пробел)
     \d - digit (цифра)
     \w - word (слово)*/

//C:\Users\Ярослав\Documents\task1910read.txt
//C:\Users\Ярослав\Documents\task1910write.txt

//C:\Users\Ярослав\Documents\task1910read - копия.txt