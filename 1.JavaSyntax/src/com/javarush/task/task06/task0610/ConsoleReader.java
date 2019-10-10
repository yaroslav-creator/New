package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString () throws Exception {

        Scanner scanner = new Scanner( System.in );
        String name = scanner.nextLine();
        return name;


    }

    public static int readInt () throws Exception {

        Scanner scanner = new Scanner( System.in );
        int a = scanner.nextInt();
        return a;

    }

    public static double readDouble () throws Exception {

        Scanner scanner = new Scanner( System.in );
        double d = scanner.nextDouble();
        return d;

    }

    public static boolean readBoolean () throws Exception {
        Scanner scanner = new Scanner( System.in );
        boolean b = scanner.nextBoolean();
        return b;

    }

    public static void main (String[] args) {

    }
}
