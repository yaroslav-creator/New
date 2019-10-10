package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {

    private static long cntSearch;
    private static int N;
    private static int[] digitsMultiSet;

    private static List<Long> results;
    private static long maxPow;
    private static long minPow;

    private static long[][] pows;
    private static long ourNumber;

    public static long[] getNumbers(long N1) {

        ourNumber = N1;
        int maxN = String.valueOf( ourNumber ).length();//определяем длину числа, 19 знаков
        if (maxN > 20) throw new IllegalArgumentException();

        genPows( maxN );
        results = new ArrayList<>();
        digitsMultiSet = new int[10];
        cntSearch = 0; //счетчик поисков

        for (N = 1; N <= maxN; N++) { //мы перебираем не числа, а количество степеней, при трехначном числе от 1 до 3
            minPow = (long) Math.pow( 10, N - 1 ); //10 в степени 0 = 1; 10; 100
            maxPow = (long) Math.pow( 10, N ); //10 в степени 1 = 10; 100; 1000
            //в перой итерации диапазон будет от 1 до 9, во второй - от 10 до 99; в третьей - от 100 до 999

            search( 0, N, 0 );

        }
        //System.out.println(cntSearch); // here we print the number of cases calculated
        //при максимальном 19-ти значном long совершается 20 030 009 проверки

        Collections.sort( results );

        long[] resultsAsArray = new long[results.size()];

        int i = 0;
        for (long x : results) {
            resultsAsArray[i] = x;
            i++;
        }

        return resultsAsArray;
    }


    private static void genPows(int N) {
        //создаю матрицу с 10 строками (однозначные числа многозначного числа)
        // и количеством степеней = длине числа (максимум - девятнадцатизначное число - максимальный long)
        if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1]; //при N = 19 предусматриваем 20 значений в каждом ряду
        for (int i = 0; i < pows.length; i++) { //число от 0 до 9
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) { //от 0 до 19
                pows[i][j] = p;
                p *= i; //при значении i = 2, мы получаем значения 1 (2^0), 2(2^1), 4(2^2) ...
                // каждый раз p является значением i в предыдущей степени, которое еще раз умножается на i, чтобы получить
                // очередную степень числа i
            }
        }
    }

    private static boolean check(long pow) { //является ли число числом Армстронга?
        cntSearch++; //счетчик поисков + 1
        if (pow >= maxPow) return false;
        if (pow < minPow) return false;
        //при трехначном начальном числе и степени 3 мы проверяем,
        //в диапазоне ли возведенное в степень число от 100 до 999

        int[] testMultiSet = new int[10];

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            pow = pow / 10;
            //по сути, у нас таблица с количеством повторений цифр от 0 до 9
            //в проверяемом возведенном в степень числе pow
            //в числе 54748 5, 7 и 8 встречаются 1 раз, а 4 - два раза, итого 5 цифр
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i]) return false;
            //для числа 54748 сравниваем testMultiSet[4] равный 2 с digitsMultiSet[4]
            //если встречаемость цифр между числом и суммой степеней его цифр разная, это по-определению разные числа
            //но если встречаемсоть цифр в двух числах одинаковая,
            //эти числа не обязательно равны, но состоящие из одинаковых цифр
            //у чисел 54748 и 45874 цифры 5, 7 и 8 встречаются 1 раз, а 4 - два раза, итого 5 цифр
        }

        //check проверят только 2 условия: является ли сумма степеней трёхзначной и одинакова ли частота цифр
        //ВНИМАНИЕ: этот алгоритм написан для вывода всех 1... N-значных чисел Армстронга
        //(для получения всех чисел меньше заданного нужно сравнивать их с нужным числом)

        //для реализации этого метода проверки нам нужно сперва наполнить массив digitsMultiSet[],
        //который является таблицей, содержащей количества повторений исходного числа

        return true;
    }

    private static void search(int digit, int unused, long pow) {
        //этот метод может вызываться как из generate(), так и рекурсивно
        if (digit == 10) {
            //это единственный случай, когда мы добавляем в наш список число
            //при рекурсии digit растет от 0 до 10, а pow от 0 до суммы степеней чисел
            //в этом методе мы решаем 2 задачи: мы считаем сумму степеней чисел и определяем частоту этих чисел
            //как только перебираем комбинации для всех 10 цифр, проверяем число
            if (check( pow ) && pow < ourNumber) results.add( pow );
            return;
        }

        if (digit == 9) {
            digitsMultiSet[digit] = unused;
            search( digit + 1, 0, pow + unused * pows[digit][N] );
        } else {
            for (int i = 0; i <= unused; i++) { //при трехзначном числе в generate() - от 0 до 3 включительно
                digitsMultiSet[digit] = i; //в первой итерации при i=0 digitsMultiSet[0] = 0
                search( digit + 1, unused - i, pow + i * pows[digit][N] );

                //при рекурсии значения переменных не изменяются,
                //но  рекурсивный метод со значением 0 вызывает сам себя со значением 1,
                //а на следующей итерации рекурсии он вызывает себя со значением 2 и так далее
                //при digit == 10 мы проверяем pow (составляющий полную сумму чисел) на число Армстронга
            }
        }

        //суть всего алгоритма в том, что ищем все числа Армстронга от 1-значных до N-значных
        //берем однозначное число, двузначные числа и их комбинации, трехзначные числа

        //например ищем все 1... 4-х значные числа Армстронга
        //создаем все возможные множества 4-цифр: для {1,2,3,4} и {1,2,3,5} ** рекурсия
        //для каждого считаем сумму 4-степеней цифр
        //проверяем, можно ли представить эту сумму при помощи цифр (встречаемость)
        //добавляем число в перечень

    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long[] resultsAsArray = getNumbers( Long.MAX_VALUE );
        // максимальное число long 9,223,372,036,854,775,807 является 19 значным
        long finish = System.currentTimeMillis();
        System.out.println( "Time consumed: " + (finish - start) + " ms" );

        for (long x : resultsAsArray) {
            System.out.print( x + " " );
        }
    }
}
