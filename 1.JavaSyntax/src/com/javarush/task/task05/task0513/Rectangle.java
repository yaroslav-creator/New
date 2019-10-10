package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int top = 0;
    int left = 0;
    int width = 0;
    int height = 0;


    public void initialize (int top, int left, int widht, int height) {
        this.top = top;
        this.left = left;
        this.width = widht;
        this.height = height;
    }

    public void initialize (int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
    }

    public void initialize (int top, int left) {
        this.top = top;
        this.left = left;
    }

    public void initialize (Rectangle rectangle) {
        this.top = rectangle.top;
        this.left = rectangle.left;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }


    public static void main (String[] args) {

    }
}
