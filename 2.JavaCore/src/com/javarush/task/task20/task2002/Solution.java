package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            // File yourFile = File.createTempFile("your_file_name", null);
            File yourFile = new File( "C:\\Users\\Ярослав\\Documents\\File 001.txt" );
            OutputStream outputStream = new FileOutputStream( yourFile );
            InputStream inputStream = new FileInputStream( yourFile );

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

//            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH);
            User user1 = new User();
            user1.setFirstName( "Ivan" );
            user1.setLastName( "Ivanov" );
            user1.setBirthDate( new Date( 130_77_13_51_6134L ) );
            user1.setMale( true );
            user1.setCountry( User.Country.OTHER );

            User user2 = new User();
            user2.setFirstName( "Vova" );
            user2.setLastName( "Petrov" );
            user2.setBirthDate( new Date( 140_78_14_62_7145L ) );
            user2.setMale( true );
            user2.setCountry( User.Country.RUSSIA );

            User user3 = new User();
            user3.setFirstName( "Ostap" );
            user3.setLastName( "Klichko" );
            user3.setBirthDate( new Date( 150_79_15_73_8156L ) );
            user3.setMale( true );
            user3.setCountry( User.Country.UKRAINE );

            javaRush.users.add( user1 );
            javaRush.users.add( user2 );
            javaRush.users.add( user3 );
            javaRush.save( outputStream );

            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load( inputStream );
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут,
            // что javaRush и loadedObject равны

            for (User user : loadedObject.users) {
                System.out.println(user.getFirstName() + " " + user.getLastName()
                        + " " + user.getCountry() + " " + user.getBirthDate());
            }
            System.out.println( javaRush.equals( loadedObject ) );

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println( "Oops, something is wrong with my file" );
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println( "Oops, something is wrong with the save/load method" );
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {

            //implement this method - реализуйте этот метод

            PrintWriter out = new PrintWriter( outputStream );
            SimpleDateFormat sdf = new SimpleDateFormat( "EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH );

            for (User user : users) {
                out.println( user.getFirstName() );
                out.println( user.getLastName() );
                out.println( sdf.format( user.getBirthDate() ) );
                out.println( user.isMale() );
                out.println( user.getCountry().name() );

            }
            out.flush();
        }

        public void load(InputStream inputStream) throws Exception {

            //implement this method - реализуйте этот метод

            BufferedReader reader = new BufferedReader( new InputStreamReader( inputStream ) );
            SimpleDateFormat sdf = new SimpleDateFormat( "EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH );

            String firstName;

            while ((firstName = reader.readLine()) != null) {

                User addUser = new User();

                addUser.setFirstName( firstName );
                addUser.setLastName( reader.readLine() );
                addUser.setBirthDate( sdf.parse( reader.readLine() ) );
                addUser.setMale( Boolean.parseBoolean( reader.readLine() ) );
                addUser.setCountry( User.Country.valueOf( reader.readLine() ) );

                users.add( addUser );
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals( javaRush.users ) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
