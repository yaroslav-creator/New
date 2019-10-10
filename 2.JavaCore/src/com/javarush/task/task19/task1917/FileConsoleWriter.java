package com.javarush.task.task19.task1917;

/* 
 Свой FileWriter
 Реализовать логику FileConsoleWriter.

 Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.

 Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.

 Класс FileConsoleWriter должен содержать пять методов write и один метод close:

 public void write(char[] cbuf, int off, int len) throws IOException
 public void write(int c) throws IOException
 public void write(String str) throws IOException
 public void write(String str, int off, int len)
 public void write(char[] cbuf) throws IOException
 public void close() throws IOException

При записи данных в файл, должен дублировать эти данные на консоль.
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter( fileName );
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter( fileName,  append );
    }

    public FileConsoleWriter(File file) throws IOException {
        this. fileWriter = new FileWriter( file );
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter( file, append );
    }

    public FileConsoleWriter(FileDescriptor fd) throws IOException {
        this.fileWriter = new FileWriter( fd );
    }

    public void write(String str) throws IOException{
        System.out.println(str);
        fileWriter.write( str );
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write( str,off, len );
        System.out.println(str.substring( off,len+ off ));

    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write( cbuf,off,len );
        System.out.println(String.valueOf( cbuf ).substring( off, off+ len ));
    }

    public void write(char[]cbuf) throws IOException {
        fileWriter.write( cbuf );
        System.out.println(cbuf);
    }

    public void  write(int c) throws IOException {
        fileWriter.write( c );
        System.out.println(c);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) {

    }


}
