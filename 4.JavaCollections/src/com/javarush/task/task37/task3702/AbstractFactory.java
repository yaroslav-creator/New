package com.javarush.task.task37.task3702;

public interface AbstractFactory {

    //интерфейс AbstractFactory, в который вынесли общий метод
    //MaleFactory & FemaleFactory, и реализуем его в этих фабриках
    Human getPerson(int age);
}
