package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
*/

public class Solution {
    public static void main(String[] args) {
        Zerg zerg1 = new Zerg();
        zerg1.name = "Zerg 1";

        Zerg zerg2 = new Zerg();
        zerg2.name = "Zerg 2";

        Zerg zerg3 = new Zerg();
        zerg3.name = "Zerg 3";

        Zerg zerg4 = new Zerg();
        zerg4.name = "Zerg 4";

        Zerg zerg5 = new Zerg();
        zerg5.name = "Zerg 5";

        Protoss protoss1 = new Protoss();
        protoss1.name = "Protoss 1";

        Protoss protoss2 = new Protoss();
        protoss2.name = "Protoss 2";

        Protoss protoss3 = new Protoss();
        protoss3.name = "Protoss 3";

        Terran terran1 = new Terran();
        terran1.name = "Terran 1";

        Terran terran2 = new Terran();
        terran2.name = "Terran 2";

        Terran terran3 = new Terran();
        terran3.name = "Terran 3";

        Terran terran4 = new Terran();
        terran4.name = "Terran 4";//напишите тут ваш код
    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
