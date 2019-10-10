package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<String> lines;

    public static void main(String[] args) throws IOException {

        if (args.length != 0) {
            lines = new ArrayList<>();


            BufferedReader consoleReader = new BufferedReader( new InputStreamReader( System.in ) );
            String fileName = consoleReader.readLine();
            consoleReader.close();

            try (BufferedReader reader = new BufferedReader( new FileReader( fileName ) )) {
                while (reader.ready()) {
                    lines.add( reader.readLine() );
                }

            }
            switch (args[0]) {
                case "-u":
                    modifyLine( args );
                    break;

                case "-d":
                    removeLine( args );
                    break;
            }
            try (BufferedWriter writer = new BufferedWriter( new FileWriter( fileName ) )) {
                for (String line : lines) {
                    writer.write( line );
                    writer.newLine();
                }
            }
            lines.clear();
        }
    }

    public static void modifyLine(String[] args) throws IllegalArgumentException {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get( i ).substring( 0, 8 ).trim().equals( args[1] )) {
                String id = args[1];
                String productName = args[2].length() > 30 ? args[2].substring( 0, 30 ) : args[2];
                String price = args[3].length() > 8 ? args[3].substring( 0, 8 ) : args[3];
                String quantity = args[4].length() > 4 ? args[4].substring( 0, 4 ) : args[4];

                String result = String.format( "%-8s%-30s%-8s%-4s", id, productName, price, quantity );
                lines.set( i, result );
                return;
            }
        }
        throw new IllegalArgumentException( "id not found" );
    }

    public static void removeLine(String[] args) throws IllegalArgumentException {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get( i ).substring( 0, 8 ).trim().equals( args[1] )) {
                lines.remove( i );
                return;
            }
        }
        throw new IllegalArgumentException( "is not found" );
    }

}
