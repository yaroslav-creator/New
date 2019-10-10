package com.javarush.task.task37.task3712;

// Класс Game должен быть абстрактным.
//паттерн Template method (Шаблонный метод)

public abstract class Game {

    public abstract void prepareForTheGame();
    public abstract void playGame();
    public abstract void congratulateWinner();

    public void run(){
        prepareForTheGame();
        playGame();
        congratulateWinner();
    }
}
