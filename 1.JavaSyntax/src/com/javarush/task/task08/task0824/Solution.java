package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human daughter = new Human( "Дочь Маша", false, 12, new ArrayList <>(  ) );
        Human son1 = new Human( "Сын Вова", true, 33, new ArrayList <>(  ) );
        Human son2 = new Human( "Сын Саня", true, 25, new ArrayList <>(  ) );

        ArrayList<Human> child = new ArrayList <>(  );
        child.add( son1 );
        child.add( son2 );
        child.add( daughter );

        Human father = new Human( "Папа Толя", true, 60, child );
        ArrayList<Human> parents1 = new ArrayList <>(  );
        parents1.add( father );

        Human mother = new Human( "Мама Нина", false, 55, child );
        ArrayList<Human> parents2 = new ArrayList <>(  );
        parents2.add(mother );


        Human grFather1 = new Human( "Дед Павел", true, 85, parents1 );
        Human grMother1 = new Human( "Баба Маша", false, 82, parents1 );

        Human grFather2 = new Human( "Дед Саша", true, 87, parents2 );
        Human grMother2 = new Human( "Баба Женя", false, 83, parents2 );

        System.out.println(grFather1.toString());
        System.out.println(grMother1.toString());
        System.out.println(grFather2.toString());
        System.out.println(grMother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(son1.toString());
        System.out.println(son2.toString());
        System.out.println(daughter.toString());

    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human (String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.children = children;
        }


        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
