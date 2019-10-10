package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        try (
                BufferedReader fileReader = new BufferedReader( new InputStreamReader( new FileInputStream( reader.readLine() ) ) )) {

            while (fileReader.ready()) {
                int i = Integer.parseInt( fileReader.readLine() );
                if (i % 2 == 0) list.add( i );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort( list );
        for (Integer num : list) System.out.println( num );

    }
}
/* кто не знает.. Создаем допустим на диске  C  текстовьій файл 1.txt пишем туда числа.
а потом в консоли запускаем задачу и пишем путь к вашему файлу у меня это C:\Users\Ярослав\Documents\someFile (2).txt
Ридер считает имя файла а Врайтер прочитает сам файл и выдаст результат

BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
InputStream inStream = new FileInputStream(reader.readLine());*/