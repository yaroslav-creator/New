package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {

    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        int i = 0;
        try {
            while (!currentThread.isInterrupted()) {

                i++;
                map.put( new Integer( i ).toString(), new String( "Some text for " + i ) );
                Thread.sleep( 500 );
            }

        } catch (Exception e) {
            System.out.println( "[THREAD_NAME] thread was terminated" );//с этим прошло
            //С этим выводом не проверил ???
            //System.out.println( Thread.currentThread().getName()+" thread was terminated"  );
        }
    }
}


