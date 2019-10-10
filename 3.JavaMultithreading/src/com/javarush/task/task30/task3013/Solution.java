package com.javarush.task.task30.task3013;

/* 
Набираем код
*/
/* Необходимо реализовать публичный метод int resetLowerBits(int number), который обнуляет все биты
в числе number, кроме самого старшего равного единице, и возвращает это число.

Число типа int это 4 байта = 32 бита. Если в метод передано число 3456, его представление
в виде битов будет 00000000 00000000 00001101 10000000. В методе нужно обнулить
все младшие биты, то есть на выходе ожидается что число, представленное в виде битов,
будет иметь вид: 00000000 00000000 00001000 00000000.
Это число 2048.

  3456 = 00000000 00000000 00001101 10000000
  2048 = 00000000 00000000 00001000 00000000

  */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;

        System.out.println( Integer.toString( number, 2 ) );

        String result = Integer.toString( solution.resetLowerBits( number ), 2 );
        System.out.println( result );

    }

    public int resetLowerBits(int number) {
        //напишите тут ваш код
        number &= ~(number >> 1);
        number &= ~(number >> 2);
        number &= ~(number >> 4);
        number &= ~(number >> 8);
        number &= ~(number >> 16);
        return number;
    }
}