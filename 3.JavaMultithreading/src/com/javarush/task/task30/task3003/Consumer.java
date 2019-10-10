package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep( 450 );
            while (true) {
//В бесконечном цикле забери элемент из очереди методом take и
// выведи в консоль "Processing item.toString()".  queue.take();
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.format( "Processing %s%n", queue.take().toString() );
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
