package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String,Cat> map = new HashMap<String, Cat>();
        Cat tom1 = new Cat("Tom1");
        Cat tom2 = new Cat("Tom2");
        Cat tom3 = new Cat("Tom3");
        Cat tom4 = new Cat("Tom4");
        Cat tom5 = new Cat("Tom5");
        Cat tom6 = new Cat("Tom6");
        Cat tom7 = new Cat("Tom7");
        Cat tom8 = new Cat("Tom8");
        Cat tom9 = new Cat("Tom9");
        Cat tom10 = new Cat("Tom10");
        map.put(tom1.name,tom1 );
        map.put(tom2.name,tom2 );
        map.put(tom3.name,tom3 );
        map.put(tom4.name,tom4 );
        map.put(tom5.name,tom5 );
        map.put(tom6.name,tom6 );
        map.put(tom7.name,tom7 );
        map.put(tom8.name,tom8 );
        map.put(tom9.name,tom9 );
        map.put(tom10.name,tom10 );
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<Cat>();

        for (Cat s : map.values())
            set.add(s);
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
