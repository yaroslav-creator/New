package com.javarush.task.task37.task3711;

/* 
Фасад
*/
public class Solution {
    public static void main(String[] args) {
        //Удали содержимое метода main класса Solution,
        // после чего добавь туда создание нового компьютера и его запуск.
        Computer computer = new Computer();
        computer.run();


//        CPU cpu = new CPU();
//        Memory memory = new Memory();
//        HardDrive hardDrive = new HardDrive();
//
//        cpu.calculate();
//        memory.allocate();
//        hardDrive.storeData();
    }
}
