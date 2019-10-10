package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {


    public static void main(String[] args) throws FileNotFoundException {
        //args = new String[]{" C:\\Users\\Ярослав\\Documents\\WriteInFile.txt"};
//       System.out.println(new PersonScannerAdapter(new Scanner(new File("C:\\Users\\Ярослав\\Documents\\WriteInFile.txt"))));
//        System.out.println();

//        String name = "Иванов Иван Иванович 13 09 1993";
//        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner(name));
//        System.out.println(adapter.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;// = new Scanner( new File( "C:\\Users\\Ярослав\\Documents\\WriteInFile.txt" ) );

        public PersonScannerAdapter(Scanner fileScanner) throws FileNotFoundException {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() {
            String string = fileScanner.nextLine();
            String[] split = string.split( " " );
            Calendar calendar = new GregorianCalendar( Integer.parseInt( split[5] ),
                    Integer.parseInt( split[4] ) - 1, Integer.parseInt( split[3] ) );
            Date date = calendar.getTime();
            Person person = new Person( split[1], split[2], split[0], date );
            return person;
        }

        @Override
        public void close() {
            fileScanner.close();
        }
    }
}


/*   В конструкторе объекта типа Scanner ты указываешь место с которого будешь читать,
это может быть клавиатура = new Scanner(System.in) или файл = new Scanner(new File("имя файла")).

Выглядит это так : Scanner scanner = new Scanner(System.in).

То есть в конструктор адаптера (в данном случае это класс PersonScannerAdapter)
ты передаёшь объект типа Scanner, который уже знает от куда ему читать.

В данной задаче это любой какой-нибудь абстрактный файл, который занесён в конструктор объекта Scanner.
Какой именно файл тебя не касается, ведь ты  работаешь с переменной типа Scanner, которая и без
тебя знает откуда ей читать данные.  */