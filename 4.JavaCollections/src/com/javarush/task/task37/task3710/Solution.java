package com.javarush.task.task37.task3710;

import com.javarush.task.task37.task3710.decorators.RedShapeDecorator;
import com.javarush.task.task37.task3710.shapes.Circle;
import com.javarush.task.task37.task3710.shapes.Rectangle;
import com.javarush.task.task37.task3710.shapes.Shape;

/* 
Decorator
*/
public class Solution {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Simple circle");
        circle.draw();

        System.out.println("\nApplied RedShapeDecorator to the circle");
        redCircle.draw();

        System.out.println("\nApplied RedShapeDecorator to the rectangle");
        redRectangle.draw();
    }
}

/*
* Вывод в консоль 1:
* Simple circle
* Drawing a shape: CIRCLE!
*
* Applied RedShapeDecorator to the circle
* Setting the border color for Circle to red.
* Drawing a shape: CIRCLE!

* Applied RedShapeDecorator to the rectangle
* Setting the border color for Rectangle to red.
* Drawing a shape: RECTANGLE!
*
*
* Вывод в консоль 2:
* Simple circle
Drawing a shape: CIRCLE!

Applied RedShapeDecorator to the circle
Setting the border color for Circle to red.
Drawing a shape: CIRCLE!

Applied RedShapeDecorator to the rectangle
Setting the border color for Rectangle to red.
Drawing a shape: RECTANGLE!
*/