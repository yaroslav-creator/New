package com.javarush.task.task25.task2512;

import java.util.Stack;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        Stack<Throwable> except = new Stack<>();
        except.push( e );

        Throwable throwable = e.getCause();
        while (throwable != null) {
            except.push( throwable );
            throwable = throwable.getCause();
        }
        while (!except.isEmpty()) {
            Throwable currExcept = except.pop();
            System.out.println( currExcept.getClass().getName() + ": " + currExcept.getMessage() );
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uncaughtException( new Thread(), new Exception( "ABC", new RuntimeException( "DEF", new IllegalAccessException( "GHI" ) ) ) );
    }
}
