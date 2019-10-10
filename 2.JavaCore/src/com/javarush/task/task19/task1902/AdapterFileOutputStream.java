package com.javarush.task.task19.task1902;

/* 
Адаптер
*/

import java.io.FileOutputStream;
import java.io.IOException;

//  класс AdapterFOS реализуем интерфейсом AmigoStringWriter
public class AdapterFileOutputStream implements AmigoStringWriter {

    private FileOutputStream fileOutputStream;  // создаем приватное поле fileOutputStream типа FileOutputStream

    public static void main(String[] args) {

    }

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) { // создаем конст-р с пар-м fileOutputStream
        this.fileOutputStream = fileOutputStream;
    }

    // добавляем методы интерфейса и передаем такие-же функции методу fileOutputStream и т.д
    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        this.fileOutputStream.write( s.getBytes() );
    }

    @Override
    public void close() throws IOException {
        this.fileOutputStream.close();
    }
}

