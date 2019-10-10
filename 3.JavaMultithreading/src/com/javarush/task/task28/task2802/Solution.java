package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup( "firstGroup" );
        Thread thread = new Thread( group, new EmulatorThreadFactoryTask() );

        ThreadGroup group2 = new ThreadGroup( "secondGroup" );
        Thread thread2 = new Thread( group2, new EmulatorThreadFactoryTask() );

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println( Thread.currentThread().getName() );
            }
        };
        factory.newThread( r ).start();
        factory.newThread( r ).start();
        factory.newThread( r ).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {

        //A - это номер фабрики инкрементируется в пределах класса начиная с 1, используйте AtomicInteger
        AtomicInteger factoryNumber = new AtomicInteger( 0 );

        //B - номер треда инкрементируется в пределах конкретной фабрики начиная с 1, используйте AtomicInteger.
        AtomicInteger integer = new AtomicInteger( 0 );

        //объявляем статический счетчик фабрик
        static AtomicInteger factoryCount = new AtomicInteger( 0 );

        // констр-р
        public AmigoThreadFactory() {
            factoryNumber.set( factoryCount.incrementAndGet() );
        }

        @Override
        public Thread newThread(Runnable r) {

            //создайте и верните трэд, который должен:
            Thread thread = new Thread( r );

            thread.setDaemon( false );  // не быть демоном
            thread.setPriority( Thread.NORM_PRIORITY );  //иметь нормальный приоритет

            // имя трэда должно иметь шаблон "GN-pool-A-thread-B"
            thread.setName( thread.getThreadGroup().getName() + "-pool-" + factoryNumber + "-thread-" + integer.incrementAndGet() );
            return thread;
        }
    }
}
