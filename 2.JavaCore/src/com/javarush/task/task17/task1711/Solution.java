package com.javarush.task.task17.task1711;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {

    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add( Person.createMale( "Иванов Иван", new Date() ) );  //сегодня родился    id=0
        allPeople.add( Person.createMale( "Петров Петр", new Date() ) );  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException, ArrayIndexOutOfBoundsException {
        //start here - начни тут

        SimpleDateFormat df = new SimpleDateFormat( "dd/MM/yyyy", Locale.ENGLISH );
        SimpleDateFormat sdf = new SimpleDateFormat( "dd-MMM-yyyy", Locale.ENGLISH );

        try {


            switch (args[0]) {

                case "-c":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 3) {
                            cParam( args[i], args[i + 1], args[i + 2] );
                        }
                    }
                    break;

                case "-u":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 4) {
                            uParam( args[i], args[i + 1], args[i + 2], args[i + 3] );
                        }
                    }
                    break;

                case "-d":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            deleteParam( args[i] );
                        }
                    }
                    break;

                case "-i":
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i++) {
                            iParam( args[i] );
                        }
                        break;
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Date simpleDataFormat(String date) {
        SimpleDateFormat format = new SimpleDateFormat( "dd/MM/yyyy", Locale.ENGLISH );
        Date tempDate = new Date();
        try {
            tempDate = format.parse( date );
        } catch (ParseException e) {
        }
        return tempDate;
    }


    public static void cParam(String name, String sex, String bd) {


        if (sex.equals( "м" )) {
            allPeople.add( Person.createMale( name, simpleDataFormat( bd ) ) );
        } else if (sex.equals( "ж" )) {
            allPeople.add( Person.createFemale( name, simpleDataFormat( bd ) ) );
        }
        System.out.println( allPeople.size() - 1 );
    }

    public static void uParam(String id, String name, String sex, String bd) {


        int index = Integer.parseInt( id );
        allPeople.get( index ).setName( name );

        if (sex.equals( "м" )) {
            allPeople.get( index ).setSex( Sex.MALE );

        } else if (sex.equals( "ж" )) {
            allPeople.get( index ).setSex( Sex.FEMALE );
        }
        allPeople.get( index ).setBirthDate( simpleDataFormat( bd ) );
    }

    public static void deleteParam(String id) {

        int index = Integer.parseInt( id );
        allPeople.get( index ).setName( null );
        allPeople.get( index ).setSex( null );
        allPeople.get( index ).setBirthDate( null );
    }

    public static void iParam(String id) {
        int index = Integer.parseInt( id );
       // String name = allPeople.get( index ).getName();

        System.out.print(allPeople.get(index).getName() + " ");
        System.out.print(allPeople.get(index).getSex().equals(Sex.MALE) ? "м " : "ж ");

        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        System.out.println(format.format(allPeople.get(index).getBirthDate()));
    }


}


