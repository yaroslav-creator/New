package com.javarush.task.task14.task1413;

public class Computer {
    private Keyboard keyboard; //В класс Computer добавь приватное поле keyboard типа Keyboard.
    private Mouse mouse;       // mouse типа Mouse
    private Monitor monitor;   //monitor  типа Monitor


    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {
    //создай конструктор с тремя параметрами в классе Computer
    // используя комбинацию клавиш Alt+Insert внутри класса (команда Constructor).

    //Внутри конструктора инициализируйте все три поля (переменных) класса
        // в соответствии с переданными параметрами.
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.monitor = monitor;
    }
//Создай геттеры для полей класса Computer
// (в классе используй комбинацию клавиш Alt+Insert и выбери команду Getter).
    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}
