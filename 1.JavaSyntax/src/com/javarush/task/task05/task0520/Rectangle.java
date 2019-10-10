package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    private int top = 0;
    private int left = 0;
    private int width = 0;
    private int height = 0;

    public Rectangle (int top, int left, int widht, int height){
        this.top = top;
        this.left = left;
        this.width = widht;
        this.height = height;
    }

    public Rectangle (int top, int left, int width){
        this.top = top;
        this.left = left;
        this.width = width;
    }

    public  Rectangle (int top, int left) {
        this.top = top;
        this.left = left;
    }

    public  Rectangle (int top) {
        this.top = top;

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
