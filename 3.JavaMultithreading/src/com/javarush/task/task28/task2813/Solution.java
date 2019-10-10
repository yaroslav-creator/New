package com.javarush.task.task28.task2813;

import java.util.concurrent.*;

/* 
FutureTask
*/

public class Solution {
    private static final ExecutorService threadpool = Executors.newFixedThreadPool(4);
    private static final int n = 16;

    public static void main(String args[]) throws InterruptedException, ExecutionException {
        FactorialCalculator task = new FactorialCalculator(n);

        System.out.println("Submitting Task ...");
        Future future = threadpool.submit(task);
        System.out.println("The task was submitted successfully");// Задание было успешно отправлено

        while (!future.isDone()) {
            System.out.println("The task is not done yet...."); //Задача еще не выполнена....
            Thread.sleep(1);
        }

        System.out.println("The task is done. Let's check the result"); //Задача выполнена. Давайте проверим результат
        long factorial = (long) future.get();

        System.out.println("Factorial of " + n + " is " + factorial);
        threadpool.shutdown();
    }
}
