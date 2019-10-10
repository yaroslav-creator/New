package com.javarush.task.task20.task2014;

import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println( new Solution( 4 ) );

        ObjectOutputStream objOS = new ObjectOutputStream( new FileOutputStream
                ( "C:\\Users\\Ярослав\\Documents\\someFile 001.txt" ) );

        Solution saveObj = new Solution( 4 );
        objOS.writeObject( saveObj );
        objOS.flush();
        objOS.close();

        Solution loadObj = new Solution( 10 );
        System.out.println( loadObj );

        ObjectInputStream objIS = new ObjectInputStream( new FileInputStream
                ( "C:\\Users\\Ярослав\\Documents\\someFile 001.txt" ) );

        loadObj = (Solution) objIS.readObject();
        System.out.println( loadObj );

        if (saveObj.string.equals( loadObj.string ))
            System.out.println( "Строки равны!" );

    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;


    public Solution(int temperature) throws IOException {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat( pattern );
        this.string = String.format( string, format.format( currentDate ), temperature );
    }

    @Override
    public String toString() {
        return this.string;
    }
}
