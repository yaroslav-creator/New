package com.javarush.task.task37.task3711;

//класс Computer, инкапсулирующий создание объектов
// и предоставляющий единую точку взаимодействия с ними.

public class Computer {
    public CPU cpu;
    public Memory memory;
    public HardDrive hardDrive;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void run(){
        cpu.calculate();
        memory.allocate();
        hardDrive.storeData();
    }
}
