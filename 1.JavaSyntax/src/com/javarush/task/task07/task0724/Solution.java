package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grFather1 = new Human("Tom",true,72  );
        Human grMother1 = new Human("Vicky",false,65  );
        Human grFather2 = new Human("Piter",true,63  );
        Human grMother2 = new Human("Linda",false,61  );
        Human father = new Human("Jack",true,45,grFather1,grMother1  );
        Human mother = new Human("Sara",false,41,grFather2,grMother2  );
        Human brother1 = new Human("Jack",true,21,father,mother  );
        Human brother2 = new Human("Stiv",true,18,father,mother  );
        Human sister = new Human("Mery",false,16,father,mother  );
        System.out.println(grFather1);
        System.out.println(grFather2);
        System.out.println(grMother1);
        System.out.println(grMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(brother1);
        System.out.println(brother2);
        System.out.println(sister);
    }

    public static class Human {
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother ){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}