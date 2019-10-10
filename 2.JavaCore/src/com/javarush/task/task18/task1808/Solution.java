package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream fis = new FileInputStream( file1 );
        FileOutputStream fos1 = new FileOutputStream( file2 );
        FileOutputStream fos2 = new FileOutputStream( file3 );

        byte[] bytes = new byte[fis.available()];

        if (fis.available() > 0) {
            int count = fis.read(bytes);
            fos1.write(bytes, 0, count / 2 + count % 2);
            fos2.write(bytes, count / 2 + count % 2, count / 2);


        }
        fis.close();
        fos1.close();
        fos2.close();
        reader.close();
    }

}
