package com.javarush.task.task20.task2015;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread( this );
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what делать что-то здесь, не важно, что
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        //В методе readObject должен быть создан новый объект типа Thread
        // с текущим объектом в качестве параметра.
        runner = new Thread( this );
        //должен быть вызван метод start у нового объекта типа Thread.
        runner.start();

    }

    public static void main(String[] args) {

    }
}

/*    Переопределение сериализации

       то есть, так как загруженный объект не будет проходить через конструктор, в котором идет
       запуск метода start() (run) потока Thread для данного объекта, то приходится после
       восстановления(загрузки из источника) запускать метод start() (run) вручную.*/