package com.javarush.task.task21.task2108;

/*
Клонирование растений
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree( "willow", new String[]{"s1", "s2", "s3", "s4"} );
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println( tree );
        System.out.println( clone );

        System.out.println( tree.branches );
        System.out.println( clone.branches );
    }

    public static class Plant {
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;


        public Tree(String name, String[] branches) {
            super( name );
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

//        @Override
//        protected Tree clone() throws CloneNotSupportedException {
//            String[] copy = new String[branches.length] ;
//            for (int i = 0; i < branches.length; i++) {
//                copy[i] = branches[i];
//
//            }
//
//
//            return new Tree (super.getName(), copy );

        @Override
        protected Tree clone() throws CloneNotSupportedException{
            if (getBranches() != null)
                return new Tree(this.getName(), this.getBranches().clone());
            else return new Tree(this.getName(), null);
        }
    }
}

/*
com.javarush.task.task21.task2108.Solution$Tree@1b6d3586
com.javarush.task.task21.task2108.Solution$Tree@4554617c
[Ljava.lang.String;@74a14482
[Ljava.lang.String;@1540e19d

com.javarush.task.task21.task2108.Solution$Tree@1b6d3586
com.javarush.task.task21.task2108.Solution$Tree@4554617c
[Ljava.lang.String;@74a14482
[Ljava.lang.String;@1540e19d

   можно так и так */