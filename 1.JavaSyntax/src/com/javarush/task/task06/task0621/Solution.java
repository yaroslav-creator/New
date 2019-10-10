package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        String grandFatherName = reader.readLine();
        Cat catgrandFather = new Cat( grandFatherName );

        String grandMotherName = reader.readLine();
        Cat catgrandMother = new Cat( grandMotherName );

        String fatherName = reader.readLine();
        Cat catFather = new Cat( fatherName, catgrandFather, null );

        String motherName = reader.readLine();
        Cat catMother = new Cat( motherName, null, catgrandMother );

        String sonName = reader.readLine();
        Cat catSon = new Cat( sonName, catFather, catMother );

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat( daughterName, catFather, catMother );

        System.out.println( catgrandFather.toString() );
        System.out.println( catgrandMother.toString() );
        System.out.println( catFather.toString() );
        System.out.println( catMother.toString() );
        System.out.println( catSon.toString() );
        System.out.println( catDaughter.toString() );
    }

    public static class Cat {
        private String name;
        private Cat father;
        private Cat mother;


        Cat (String name) {

            this.name = name;
        }


        Cat (String name, Cat parent, Cat parent2) {
            this.name = name;
            this.father = parent;
            this.mother = parent2;

        }


        @Override
        public String toString () {
            if ((mother == null) && (father == null))
                return "The cat's name is " + name + ", no mother " + ", no father ";

            else if ((mother != null) && (father == null))
                return "The cat's name is " + name + ", mother is " + mother.name + ", no father";
            else if ((mother == null) && (father != null))
                return "The cat's name is " + name + ", no mother, father is " + father.name;

            else return "The cat's name is " + name + ", mother is " + mother.name + ", father is " + father.name;
        }
    }

}
