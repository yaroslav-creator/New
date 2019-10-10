package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {

    Thread thread;


    @Override
    public void start(String threadName) {
        this.thread = new Thread(this);
        this.thread.setName(threadName);
        this.thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }

    @Override

    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            while (!thread.isInterrupted()) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName());
                //Thread.sleep(100);
            }
        } catch (InterruptedException e) {

        }
    }
}
