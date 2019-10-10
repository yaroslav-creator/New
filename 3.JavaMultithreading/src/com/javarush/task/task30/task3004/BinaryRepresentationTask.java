package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {

    private int x;

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf( a );

        if (b > 0) {
            BinaryRepresentationTask binary = new BinaryRepresentationTask( b );
            return binary.fork().join() + result;
        }
        return result;
    }

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }
}
