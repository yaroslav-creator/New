package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами

Считайте с консоли имя файла, который имеет HTML-формат.

Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Первым параметром в метод main приходит тег. Например, "span".
Вывести на консоль все теги, которые соответствуют заданному тегу.
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле.
Количество пробелов, \n, \r не влияют на результат.

Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нет.
Тег может содержать вложенные теги.

    C:\Users\Ярослав\Documents\Регулярные выражения — Википедия.html

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));

        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null){
            sb.append(line);
        }
        reader.close();

        String openTag = "<"+args[0];
        String closeTag = "</"+args[0]+">";

        // ищем все открывающие тэги и запоминаем их индексы расположения в строке
        List<Integer> openList = new ArrayList<>();
        int startIndex = 0;
        int index;
        while (true) {
            index = sb.indexOf(openTag, startIndex);
            if (index == -1) break;
            openList.add(index);
            startIndex = index+1;
        }

        // ищем все закрывающие тэги и запоминаем их индексы расположения в строке
        List<Integer> closeList = new ArrayList<>();
        startIndex = 0;
        while (true) {
            index = sb.indexOf(closeTag, startIndex);
            if (index == -1) break;
            closeList.add(index);
            startIndex = index+1;
        }

        // берем первый openTag и идем до closeTag, считаю openTag-и по пути (уровень вложенности)
        int closeID, openID, level = 0;
        while (openList.size() != 0) {
            for (int i = 0; i < openList.size(); i++) {
                if (openList.get(i) < closeList.get(0)) level++;
                else break;
            }
            for (int i = level-1; i >= 0; i--) {
                openID = openList.get(0);
                closeID = closeList.get(i);
                line = sb.substring(openID, closeID);
                System.out.println(line+closeTag);
                openList.remove(0);
                closeList.remove(i);
                level = 0;
                break;
            }
        }
    }

}


/*    Пример вывода:
   <span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
   <span>Turanga Leela</span>
   <span>Super</span>
   <span>girl</span>

     Шаблон:
   <tag>text1</tag>
   <tag text2>text1</tag>
   <tag
   text2>text1</tag>
   text1, text2 могут быть пустыми*/