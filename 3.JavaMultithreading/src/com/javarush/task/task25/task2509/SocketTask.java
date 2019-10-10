package com.javarush.task.task25.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        //close all resources here
        try {
            socket.close();
        }catch (IOException e) {}
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {

                //close all resources here by using proper SocketTask method
                //закройте все ресурсы здесь, используя правильный метод SocketTask

                //call super-class method in finally block
                //вызвать метод суперкласса в блоке finally

                try {
                    socket.close();
                }catch (IOException e) {}
                finally {
                    super.cancel( mayInterruptIfRunning );
                }
                return false;
            }
        };
    }
}