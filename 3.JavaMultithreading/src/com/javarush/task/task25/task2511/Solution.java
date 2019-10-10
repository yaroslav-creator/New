package com.javarush.task.task25.task2511;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {

        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String s = t.getName().replaceAll( ".", "*" );
                String message = e.getMessage().replaceAll( t.getName(), s );
                e = new Exception( message, e );
                System.out.println(e.getMessage());
                t.setName( s );
            }
        };  //init handler here

    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
    }
}