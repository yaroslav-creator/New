package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger( Solution.class );

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {

        //debug - используй при изменениях значений полей класса;
        logger.debug( "Constructor: " + value1 + " " + value2 + " " + value3 );

        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public static void main(String[] args) throws IOException {

    }

    public void calculateAndSetValue3(long value) {

        // trace - используй для отслеживания пути выполнения програмы;
        logger.trace( "calculateAndSetValue3" );

        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);

            //debug - используй при изменениях значений полей класса;
            logger.debug( "newValue1: ", value1 );

        } else {
            value1 = (int) value;

            //debug - используй при изменениях значений полей класса;
            logger.debug( "newValue1: ", value1 );
        }
    }

    public void printString() {

        // trace - используй для отслеживания пути выполнения програмы;
        logger.trace( "printValue2" );

        if (value2 != null) {
            System.out.println( value2.length() );
        }
    }

    public void printDateAsLong() {

        // trace - используй для отслеживания пути выполнения програмы;
        logger.trace( "printDateLong" );

        if (value3 != null) {
            System.out.println( value3.getTime() );
        }
    }

    public void divide(int number1, int number2) {

        // trace - используй для отслеживания пути выполнения програмы;
        logger.trace( "divide num1/num2" );

        try {
            System.out.println( number1 / number2 );
        } catch (ArithmeticException e) {

            //error - используй для получения ошибок;
            logger.error( "Unknown error", e );
        }
    }

    public void setValue1(int value1) {
        this.value1 = value1;

        //debug - используй при изменениях значений полей класса;
        logger.debug( "setValue1: ", value1 );
    }

    public void setValue2(String value2) {
        this.value2 = value2;

        //debug - используй при изменениях значений полей класса;
        logger.debug( "seValue2: ", value2 );
    }

    public void setValue3(Date value3) {
        this.value3 = value3;

        //debug - используй при изменениях значений полей класса;
        logger.debug( "setValue3: ", value3 );
    }
}
