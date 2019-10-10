package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.HHStrategy;
import com.javarush.task.task28.task2810.model.Provider;

/**
 * Пришло время немного поработать с информацией в инете. В этом задании ты будешь
 * писать агрегатор java вакансий.
 * Что у нас должно быть?
 * Должен быть список сайтов, на которых мы ищем вакансии.
 * Для начала возьмем http://hh.ua/ и http://hh.ru/, потом уже добавим другие сайты поиска работы.
 * Это один и тот же сайт, только в разных доменах.
 * */
public class Aggregator {
    public static void main(String[] args) {

        //5. В методе main создай провайдер, а потом создай контроллер с этим провайдером.
        Provider provider = new Provider(new HHStrategy());
        Controller controller = new Controller(provider);
        controller.scan();

//        //6. В методе main выведи в консоль созданный экземпляр Controller-а.
//        System.out.println(controller);
    }
}
