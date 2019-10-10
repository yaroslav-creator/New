package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

//Сейчас мы напишем свой фильтр: унаследованный от FileFilter.
public class HTMLFileFilter extends FileFilter {

    //Мы хотим, чтобы окно выбора файла отображало только html/htm файлы или папки.
    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
            //он возвращал true, если переданный файл директория,
            // или содержит в конце имени ".html" или ".htm" без учета регистра.

        } else
            return f.getName().toLowerCase().endsWith( ".html" )
                    || f.getName().toLowerCase().endsWith( ".htm" );
    }

    //Чтобы в окне выбора файла в описании доступных типов файлов отображался текст "HTML и HTM файлы"
    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
