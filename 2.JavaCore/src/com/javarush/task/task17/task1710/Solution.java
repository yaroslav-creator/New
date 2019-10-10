package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add( Person.createMale( "Ivanov Ivan", new Date() ) );  //сегодня родился    id=0
        allPeople.add( Person.createMale( "Petrov Petr", new Date() ) );  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String name;
        Sex sex;  // sex - пол, "м" или "ж", одна буква
        Date bd;  // дата рождения в следующем формате 15/04/1990
        Person p;
        int id;   //id соответствует индексу в списке.

        SimpleDateFormat format = new SimpleDateFormat( "dd/MM/yyyy", Locale.ENGLISH );

        //-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
        if (args[0].equals( "-c" )) {
            name = args[1];
            sex = (args[2].equals( "m" )) ? Sex.MALE : Sex.FEMALE;
            bd = format.parse( args[3] );

            if (sex == Sex.MALE) {
                p = Person.createMale( name, bd );
            } else {
                p = Person.createFemale( name, bd );
            }
            allPeople.add( p );
            System.out.println( allPeople.indexOf( p ) );
        }

            // -u - обновляет данные человека с данным id
        if (args[0].equals( "-u" )) {
            id = Integer.parseInt( args[1] );
            name = args[2];
            sex = (args[3].equals( "m" )) ? Sex.MALE : Sex.FEMALE;
            bd = format.parse( args[4] );
            p = allPeople.get( id );
            p.setName( name );
            p.setSex( sex );
            p.setBirthDate( bd );
        }

             // -d - производит логическое удаление человека с id, заменяет все его данные на null
        if (args[0].equals( "-d" )) {
            id = Integer.parseInt( args[1] );
            p = allPeople.get( id );
            p.setSex( null );
            p.setBirthDate( null );
            p.setName( null );
        }

            // -i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
        if (args[0].equals( "-i" )) {
            id = Integer.parseInt( args[1] );
            p = allPeople.get( id );
            String sx = (p.getSex() == Sex.MALE) ? "m" : "w";
            SimpleDateFormat sdf = new SimpleDateFormat( "dd-MMM-yyy", Locale.ENGLISH );
            System.out.println( p.getName() + " " + sx + " " + sdf.format( p.getBirthDate() ) );
        }
    }
}
