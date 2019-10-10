package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Смена кодировки
// C:\Users\Ярослав\Documents\Файлы JavaRush\task2211_win1251.txt
// C:\Users\Ярослав\Documents\Файлы JavaRush\task2211_UTF8.txt
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);


        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);

        String s = new String( bytes,"Windows-1251" );
        bytes = s.getBytes("UTF-8");
        outputStream.write( bytes );

        inputStream.close();
        outputStream.close();

    }
}
