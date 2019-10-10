package com.javarush.task.task28.task2812;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
ShutdownNow!
*/

/*  велено разобраться в отличиях shutdown и shutdownNow.
итак,
shutdown - просто вежливо сообщается executor'у, что больше новые задания на исполнение не принимать!
При этом спокойно ждет времени сколько понадобится, чтобы все полученные задания выполнились.
Даже те, которые еще не начинали выполняться, но находятся в очереди.

shutdownNow - так же не разрешает принимать новые задания, вдобавок он делает interruption. Подразумевается,
что корректно составленные задания отреагируют на interruption и сразу прервутся.
Но в общем случае, выполнение каких-то заданий все равно может продолжиться.

 В список возвращаемый методом shutdownNow попадут только те задания, которые НЕ НАЧАЛИ ИСПОЛНЕНИЕ
 Те задания, КОТОРЫЕ БЫЛИ ПРЕРВАНЫ, - НЕ ПОПАДУТ.*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }

        List<Runnable> list = executor.shutdownNow();
        for (Runnable runnable : list){
            System.out.println(runnable.toString() + " was not completed");
        }
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}

/*  add(); - Вставляет указанный элемент в эту очередь, если это возможно сделать немедленно,
не нарушая ограничений емкости, возвращая true при успешном выполнении и бросая исключение
IllegalStateException, если в настоящее время нет свободного места.

put(); - Вставляет указанный элемент в хвост этой очереди, ожидая при необходимости, чтобы пространство стало доступным.

offer(); - Вставляет указанный элемент в хвост этой очереди, ожидая при необходимости до указанного времени ожидания,
чтобы пространство стало доступным. */