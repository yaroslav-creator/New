package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.Human;

public class TeenBoy implements Human {

    public static final int MAX_AGE = 19;

    //Для статик полей автоматический toString не создаётся.
    // Чтобы создать автоматический toString - нажмите Select Name
    @Override
    public String toString() {
        return "TeenBoy{}";
    }
}
