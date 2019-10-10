package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

public class FunctionalTest {

    public void testStorage(Shortener shortener){
        //14.4.1. Создавать три строки. Текст 1 и 3 строк должен быть одинаковым.
        String s1 = Helper.generateRandomString();
        String s2 = Helper.generateRandomString();
        String s3 = s1;

        //14.4.2. Получать и сохранять идентификаторы для всех трех строк с помощью shortener.
        Long id1 = shortener.getId( s1 );
        Long id2 = shortener.getId( s2 );
        Long id3 = shortener.getId( s3 );

        //14.4.3. Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк.
        Assert.assertNotEquals( id2, id1 );
        Assert.assertNotEquals( id2, id3 );

        //14.4.4. Проверять, что идентификаторы для 1 и 3 строк равны.
        Assert.assertEquals( id1, id3 );

        //14.4.5. Получать три строки по трем идентификаторам с помощью shortener.
        //14.4.6. Проверять, что строки, полученные в предыдущем пункте, эквивалентны оригинальным.
        Assert.assertEquals( s1, shortener.getString( id1 ) );
        Assert.assertEquals( s2, shortener.getString( id2 ) );
        Assert.assertEquals( s3, shortener.getString( id3 ) );
    }

    @Test
    public void testHashMapStorageStrategy(){
        HashMapStorageStrategy strategy1 = new HashMapStorageStrategy();
        Shortener shortener = new Shortener( strategy1 );
        testStorage( shortener );
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        OurHashMapStorageStrategy strategy2 = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener( strategy2 );
        testStorage( shortener );
    }

    @Test
    public void testFileStorageStrategy(){
        FileStorageStrategy strategy3 = new FileStorageStrategy();
        Shortener shortener = new Shortener( strategy3 );
        testStorage( shortener );
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        HashBiMapStorageStrategy strategy4 = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener( strategy4);
        testStorage( shortener );
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        DualHashBidiMapStorageStrategy strategy5 = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener( strategy5 );
        testStorage( shortener );
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        OurHashBiMapStorageStrategy strategy6 = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener( strategy6 );
        testStorage( shortener );
    }

}
