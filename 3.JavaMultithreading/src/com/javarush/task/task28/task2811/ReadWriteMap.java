package com.javarush.task.task28.task2811;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteMap<K, V> {
    private final Map<K, V> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock;
    private final Lock writeLock;

    public ReadWriteMap(Map<K, V> map) {
        this.map = map;
        //Поле readLock должно быть инициализировано с помощью метода readLock вызванного на объекте lock.
        this.readLock = lock.readLock();
        //Поле writeLock должно быть инициализировано с помощью метода writeLock вызванного на объекте lock.
        this.writeLock = lock.writeLock();
    }

    public V put(K key, V value) {

        //	В методе put должен быть вызван метод lock на объекте writeLock.
        writeLock.lock();
        try {
            return map.put( key, value );
        } finally {

            //В методе put в блоке finally должен быть вызван метод unlock на объекте writeLock.
            writeLock.unlock();
        }
    }

    public V get(K key) {

        //В методе get должен быть вызван метод lock на объекте readLock.
        readLock.lock();

        try {
            return map.get( key );
        } finally {

            //В методе get в блоке finally должен быть вызван метод unlock на объекте readLock.
            readLock.unlock();
        }
    }
}

/*   1) ReentrantReadWriteLock - это усовершенствованная версия ReentrantLock, которая дает более высокую
производительность при множественных операциях чтения и записи из разных потоков.

2) поток чтения, пытающийся захватить readLock, смотрит, не занят ли writeLock. если не занят, то тогда
(именно в имплементации ReentrantReadLock) он смотрит, не стоит ли в очереди ожидания поток записи:

- если нет, то захватывает readLock, независимо от того, захвачен ли этот readLock кем-то еще;
- если поток записи уже ждет окончания чтения, то наш поток чтения становится в хвост очереди
(несмотря на то, что идет операция чтения одним или несколькими потоками).

3) поток записи сможет захватить writeLock только в том случае, когда оба лока readLock и writeLock не заняты.
 В ином случае он попадает в очередь ожидания.

Итого: чтение может осуществляться несколькими потоками одновременно, запись - только одним
(при обязательном отсутствии читающих).

readLock может быть захвачен несколькими потоками, writeLock - только одним.*/