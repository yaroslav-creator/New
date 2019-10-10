package com.javarush.task.task28.task2807;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
Знакомство с ThreadPoolExecutor
*/
public class Solution {

    public static int id = 1;

    public static void main(String[] args) throws InterruptedException {
        // Add your code here

        //В методе main создай очередь LinkedBlockingQueue<Runnable>.
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

        //В цикле добавь в очередь 10 задач Runnable.
        for (int i = 0; i < 10; i++) {

            queue.add( () -> {
                doExpensiveOperation( id++ );
            } );
        }

        // Создай объект ThreadPoolExecutor со следующими параметрами:
        //- основное количество трэдов (ядро) = 3,
        //- максимальное количество трэдов = 5,
        //- время удержания трэда живым после завершения работы = 1000,
        //- тайм-юнит - миллисекунды
        //- созданная в п.1. очередь с задачами.
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                ( 3, 5, 1000, TimeUnit.MILLISECONDS, queue );

        //Запусти все трэды, которые входят в основное кол-во трэдов - ядро, используй метод prestartAllCoreThreads.
        executor.prestartAllCoreThreads();

        executor.shutdown();//Запрети добавление новых задач на исполнение в пул (метод shutdown).

        //Дай объекту ThreadPoolExecutor 5 секунд на завершение всех тасок (метод awaitTermination и параметр TimeUnit.SECONDS).
        executor.awaitTermination(5, TimeUnit.SECONDS  );

        /* Example output
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println( Thread.currentThread().getName() + ", localId=" + localId );
    }
}
