package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    Thread thread;

    public LoggingStateThread(Thread thread){
        this.thread = thread;
    }

    @Override
    public void run() {
        Thread.State state = thread.getState();
        System.out.println(state);
        super.run();
        while (!state.equals( State.TERMINATED )){
            Thread.State newState = thread.getState();
            if (!newState.equals( state )){
                System.out.println(newState);
                state = newState;
            }
        }
    }
}
