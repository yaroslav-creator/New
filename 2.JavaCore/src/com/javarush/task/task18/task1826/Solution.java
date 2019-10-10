package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class Solution {
    public static void main(String[] args) throws IOException {

        // args = new String[]{"-e", "d:\\_JavaRush\\_Test\\Dear Sir or Madam.txt", "d:\\_JavaRush\\_Test\\temp.txt"};
        // args = new String[]{"-d", "d:\\_JavaRush\\_Test\\temp.txt", "d:\\_JavaRush\\_Test\\Dear Sir or Madam.txt"};


        // создаем входной поток чтения байт из файла
        try (FileInputStream inputStream = new FileInputStream( args[1] );

             // создаем выходной поток записи байт в файл
             FileOutputStream outputStream = new FileOutputStream( args[2] )) {

            while (inputStream.available() > 0) {         //пока есть еще непрочитанные байты
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read( bytes );

                // В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
                if (args[0].equals( "-e" )) {
                    byte[] encode = Base64.getEncoder().encode( bytes );
                    outputStream.write( encode );

                // В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
                } else if (args[0].equals( "-d" )) {
                    byte[] decode = Base64.getDecoder().decode( bytes );
                    outputStream.write( decode );
                }
            }
        }
    }
}
