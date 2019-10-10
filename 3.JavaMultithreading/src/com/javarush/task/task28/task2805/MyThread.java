package com.javarush.task.task28.task2805;


/*   Задача "Приоритеты в Threads" демонстрирует, что нельзя у отдельной нити
(принадлежащей к группе нитей) установить приоритет БОЛЬШИЙ, чем у группы, к которой она принадлежит,
чтобы это понять - нужно перейти в класс Thread и там посмотреть, как устроен метод setPriority

public final void setPriority(int newPriority) {
        ThreadGroup g;
        checkAccess();
        if (newPriority > MAX_PRIORITY || newPriority < MIN_PRIORITY) {
            throw new IllegalArgumentException();
        }
        if((g = getThreadGroup()) != null) {
            if (newPriority > g.getMaxPriority()) {
                newPriority = g.getMaxPriority();
            }
            setPriority0(priority = newPriority);
        }
    }
    */
import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {

    public static AtomicInteger counter = new AtomicInteger( 1 );

    public void priority() {
        if (counter.get() < 10) setPriority( counter.getAndIncrement() );
        else {
            setPriority( counter.get() );
            counter.set( 1 );
        }
    }

    public MyThread() {
        // super();
        priority();
    }

    public MyThread(Runnable target) {
        super( target );
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super( group, target );
        priority();
    }

    public MyThread(String name) {
        super( name );
        priority();
    }

    public MyThread(ThreadGroup group, String name) {
        super( group, name );
       priority();
    }

    public MyThread(Runnable target, String name) {
        super( target, name );
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super( group, target, name );
        priority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super( group, target, name, stackSize );
       priority();
    }
}
