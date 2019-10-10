package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;

     String fileName;

    //В конструкторе класса Solution поле stream должно быть инициализировано новым объектом
    // типа FileOutputStream с параметром(fileName).
    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);

        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
       // out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
       // in.close();
        stream = new FileOutputStream( fileName, true );

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution( "C:\\Users\\Ярослав\\Documents\\task2022.txt" );
        solution.writeObject( "Hello world!\r\n" );
        ObjectOutputStream outputStream = new ObjectOutputStream( new FileOutputStream( "C:\\Users\\Ярослав\\Documents\\task20221.txt" ) );
        outputStream.writeObject( solution );

        ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream( "C:\\Users\\Ярослав\\Documents\\task20221.txt" ) );
        Solution solution1 = (Solution) inputStream.readObject();
        solution1.writeObject( "Hello Yaroslav!" );

    }
}
