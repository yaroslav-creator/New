package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        /*использование java.util.HashMap*/
        testStrategy( new HashMapStorageStrategy(), 10000 );

        /*использование самописного специализированного аналога HashMap, вида HashMap<Long,String>*/
        testStrategy( new OurHashMapStorageStrategy(), 10000 );

        /* использование самописного специализированного аналога HashMap,
        c FileBucket в качестве ведер (англ. bucket)*/
        testStrategy( new FileStorageStrategy(), 100 );

        /*использование в связке двух коллекций */
        testStrategy(new OurHashBiMapStorageStrategy(), 10000);

        /*рассмотрим реализацию HashBiMap из сторонней библиотеки коллекций Guava от Google.*/
        testStrategy(new HashBiMapStorageStrategy(), 10000);

        /*рассмотрим еще одну реализацию BiMap, на этот раз из Apache Commons Collections.*/
        testStrategy(new DualHashBidiMapStorageStrategy(), 10000);
    }

    //Этот метод должен для переданного множества строк возвращать множество идентификаторов.
    //Идентификатор для каждой отдельной строки нужно получить, используя shortener.
    public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
        Set<Long> result = new HashSet<>();
        for (String s : strings) {
            result.add( shortener.getId( s ) );
        }
        return result;
    }

    //Метод будет возвращать множество строк, которое соответствует переданному множеству идентификаторов.
    public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
        Set<String> result = new HashSet<>();
        for (Long key : keys) {
            result.add( shortener.getString( key ) );
        }
        return result;
    }

    //Метод будет тестировать работу переданной стратегии на определенном количестве элементов elementsNumber.
    public static void testStrategy(StorageStrategy strategy, long elementsNumber) {

        //6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
//        System.out.println(strategy.getClass().getSimpleName());
        Helper.printMessage( strategy.getClass().getSimpleName() );

        //6.2.3.2. Генерировать тестовое множество строк
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
            strings.add( Helper.generateRandomString() );

        //6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.
        Shortener shortener = new Shortener( strategy );

        //6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии.
        // Время вывести в миллисекундах. Замер времени произведи с использованием объектов типа Date.
        Long start_ids = new Date().getTime();
        Set<Long> ids = getIds( shortener, strings );

        Long finish_ids = new Date().getTime();
        long delta_ids = finish_ids - start_ids;

        Helper.printMessage( Long.toString( delta_ids ) );

        //6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии
        Long start_strs = new Date().getTime();
        Set<String> strs = getStrings( shortener, ids );

        Long finish_strs = new Date().getTime();
        long delta_strs = finish_strs - start_strs;

        Helper.printMessage( Long.toString( delta_strs ) );

        //6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано
        // и множества, которое было возвращено методом getStrings.

        if (strings.equals( strs )) {
            Helper.printMessage( "Тест пройден." );
        } else {
            Helper.printMessage( "Тест не пройден." );
        }
    }
}
