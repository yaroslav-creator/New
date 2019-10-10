package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
//
//    //volume - будет значением сама строка.
//    private String string;
//
//    //key - ключом будет идентификатор строки,
//    private Long id;

    //в котором будет храниться стратегия хранения данных.
    private Long lastId = 0L;

    //должно быть создано приватное поле storageStrategy типа StorageStrategy.
    private StorageStrategy storageStrategy;

    //Конструктор класса Shortener должен принимать один параметр типа StorageStrategy
    // и инициализировать им поле storageStrategy.
    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string) {

        if (storageStrategy.containsValue( string )) {
            return storageStrategy.getKey( string );

        } else {
            lastId++;
            storageStrategy.put( lastId, string );
        }
        return lastId;
    }

    public String getString(Long id) {
        return storageStrategy.getValue( id );
    }
}
