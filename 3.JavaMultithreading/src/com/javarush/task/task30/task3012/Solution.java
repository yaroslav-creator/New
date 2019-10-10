package com.javarush.task.task30.task3012;

/* 
Получи заданное число

Метод createExpression вызывается с одним параметром number.
Этот параметр - число от 1 до 3000 включительно.
Нужно вывести арифметическое выражение, результатом которого является число number.
Можно использовать числа: 1, 3, 9, 27, 81, 243, 729, 2187 не более, чем по одному разу.
Можно использовать знаки: "+" и "-" любое количество раз.
Обрати внимание, что перед каждым числом в искомой строке обязательно должен быть
Переданное число:
74
Ожидаемый вывод:
74 = - 1 + 3 - 9 + 81
При выводе выражения используй числа ТОЛЬКО В ВОЗРАСТАЮЩЕМ порядке!знак плюс или минус.
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        StringBuilder result = new StringBuilder( number + " =" );
        int rem;
        int sum = 0;
        while (number > 0) {
            rem = number % 3;
            number /= 3;
            if (rem == 2) {
                rem = -1;
                number++;
            }
            result.append( rem == 0 ? "" : ((rem == 1) ? " + " : " - ") + (int) Math.pow( 3, sum ) );
            sum++;
        }
        System.out.println(result);
    }
}