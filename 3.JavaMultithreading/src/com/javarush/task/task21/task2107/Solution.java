package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {
    @Override                                   // переопределяем метод
    protected Solution clone() throws CloneNotSupportedException {
        Solution copy = new Solution();  //создаем копию новый объект
        copy.users = new LinkedHashMap<>( this.users ); // копируем в линккарту
        copy.users.putAll(this.users );  // добав. юзеров со всеми параметрами
        return copy;                     // возвр. копию
    }

    @Override                       // переопределяем метод
    public int hashCode() {
        if (users == null)return 0; // проверка на наличие
        return users.hashCode();
    }

    @Override                           // переопределяем метод
    public boolean equals(Object obj) {
        if (this == obj)return true;      // проверка что это равно объекту
        if (getClass() != obj.getClass()) return false;
        Solution solution = (Solution)obj;
        return users.equals( this.users );
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put( "Hubert", new User( 172, "Hubert" ) );
        solution.users.put( "Zapp", new User( 41, "Zapp" ) );
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println( solution );
            System.out.println( clone );

            System.out.println( solution.users );
            System.out.println( clone.users );

        } catch (CloneNotSupportedException e) {
            e.printStackTrace( System.err );
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        @Override                       // переопределяем метод
        protected Object clone() throws CloneNotSupportedException {

            return super.clone();
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
