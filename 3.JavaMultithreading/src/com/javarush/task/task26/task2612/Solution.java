package com.javarush.task.task26.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // Implement the logic here. Use the lock field
        lock.lock();

        if (lock.tryLock()) {
            try {
                actionIfLockIsFree();//действие, если блокировка свободна

            } finally {
                lock.unlock();//разблокировать lock
            }
        }else {
            actionIfLockIsBusy();//действие, если блокировка занята
        }
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}
