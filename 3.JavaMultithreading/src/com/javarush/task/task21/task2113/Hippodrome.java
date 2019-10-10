package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {

        List<Horse> horseList = new ArrayList<>();
        game = new Hippodrome( horseList );

        horseList.add( new Horse( "Horse1", 3, 0 ) );
        horseList.add( new Horse( "Horse2", 3, 0 ) );
        horseList.add( new Horse( "Horse3", 3, 0 ) );

        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep( 200 );
        }
    }

    public void move() {
            horses.forEach( Horse::move );
    }


    public void print() {
        horses.forEach( Horse::print );
        for (int i = 0; i< 10; i++) System.out.println();
    }

    public Horse getWinner(){
        Horse winner = horses.get( 0 );
        for (int i = 0; i < horses.size(); i++){
            if (winner.distance < horses.get( i ).distance){
                winner = horses.get( i );
            }
        }return winner;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

}
