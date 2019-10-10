package com.javarush.task.task26.task2608;

/* 
Мудрый человек думает раз, прежде чем два раза сказать
*/
public class Solution {
    int var1;
    int var2;
    int var3;
    int var4;

    /* Синхронизированные операторы также полезны для улучшения параллелизма с тонкой синхронизацией.
    * Предположим, например, у класса есть 4 поля экземпляра, (var1 и var2) и (var3 и var4), 2 из которых
     * никогда не используются вместе. Все обновления этих полей должны быть синхронизированы, но нет причин
     * препятствовать тому, чтобы обновление С1(var1 и var2) чередовалось с обновлением С2 (var3 и var4) —
     * и это уменьшает параллелизм, создавая ненужную блокировку.
     *
     * Вместо использования синхронизированных методов или других связанных с (this) блокировок,
      * мы создаем два объекта исключительно для обеспечения блокировок.
      *
      * Используйте эту идиому с особой осторожностью. Вы должны быть абсолютно уверены,
      * что действительно безопасно чередовать доступ к затронутым полям.*/

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();


    public Solution(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2() {
        synchronized (lock1) {
            return var1 + var2;
        }
    }

    public int getSumOfVar3AndVar4() {
        synchronized (lock2) {
            return var3 + var4;
        }
    }

    public static void main(String[] args) {

    }
}
