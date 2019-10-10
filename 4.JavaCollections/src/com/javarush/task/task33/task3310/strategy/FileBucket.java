package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
      Path path;

     //9.3. Добавь в класс конструктор без параметров
    public FileBucket() {
        try {
            //9.3.1. Инициализировать path временным файлом. Файл должен быть размещен
            // в директории для временных файлов и иметь случайное имя.
            path = Files.createTempFile( null, null );

            //9.3.2. Создавать новый файл, используя path.
            Files.deleteIfExists( path );//Если такой файл уже есть, то заменять его.
            Files.createFile( path );

        }catch (IOException e){
            ExceptionHandler.log( e );
        }
        //9.3.3. Обеспечивать удаление файла при выходе из программы.
        path.toFile().deleteOnExit();
    }

    //Должен возвращать размер файла на который указывает path.
    public long getFileSize(){
        try {
            return Files.size( path );
        }catch (IOException e){
            e.printStackTrace();
        }
        return 0;
    }

    //Должен сериализовывать переданный entry в файл.
    // Учти, каждый entry может содержать еще один entry.
    public void putEntry(Entry entry){
        try(ObjectOutputStream oos = new ObjectOutputStream( Files.newOutputStream( path ) )){
            oos.writeObject( entry );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.
    public Entry getEntry(){
        Entry entry = null;

        if (getFileSize() <= 0)
            return null;

        try(ObjectInputStream ois = new ObjectInputStream( Files.newInputStream( path ) )){
            entry = (Entry) ois.readObject();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return entry;
    }
    //Должен удалять файл на который указывает path.
    public void remove(){
        try {
            Files.delete( path );
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
