package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

/**
 * Он будет отвечать за получение данных с сайта.
 * */
public interface Strategy {

    // метод getVacancies(String searchString), который будет возвращать список вакансий.
     public List<Vacancy> getVacancies(String searchString);
}
