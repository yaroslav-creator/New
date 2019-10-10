package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

public class RedShapeDecorator extends ShapeDecorator {
    private Shape shape;

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.shape = decoratedShape;
    }

    //Он должен выводить на экран фразу "Setting the border color for XXX to red."
    //XXX - имя конкретного декорируемого класса
    private void setBorderColor(Shape shapeDecorator) {
        System.out.println("Setting the border color for " +
                shapeDecorator.getClass().getSimpleName() + " to red.");

//        System.out.println(String.format("Setting the border color for %s to red.",
//                shapeDecorator.getClass().getSimpleName()));
    }

    @Override
    // Переопредели метод draw(), в нем сначала измени цвет отображаемого объекта
    // с помощью метода setBorderColor(), а потом нарисуй его.
    public void draw() {
        setBorderColor(shape);
        super.draw();
    }
}
