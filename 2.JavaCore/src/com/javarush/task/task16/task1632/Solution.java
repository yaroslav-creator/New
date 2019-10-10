package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>( 5 );

    static {
        threads.add( new Thread1() );
        threads.add( new Thread2() );
        threads.add( new Thread3() );
        threads.add( new Thread4() );
        threads.add( new Thread5() );

    }

    public static void main(String[] args) {
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep( 1 );
                } catch (InterruptedException e) {
                    System.out.println( "InterruptedException" );
                }
            }
        }
    }

    private static class Thread3 extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println( "Ура" );
                try {
                    Thread.sleep( 500 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Thread4 extends Thread implements Message {

        @Override
        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    private static class Thread5 extends Thread {
        @Override
        public void run() {
            String line;
            int result = 0;
            try (BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) )) {
                while (!(line = reader.readLine()).equals( "N" )){
                    result += Integer.parseInt( line );
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(result);
        }
    }
}





