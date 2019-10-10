package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Этот класс будет реализовывать конкретную стратегию работы с сайтом ХэдХантер
 * (http://hh.ua/ и http://hh.ru/).
 * */
public class HHStrategy implements Strategy{

    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        try {
            Document document = Jsoup.connect(URL_FORMAT)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 YaBrowser/19.9.0.1343 Yowser/2.5 Safari/537.36")
                    .referrer("").get();
           // Document document = Jsoup.connect(URL_FORMAT)
            // .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36")
            // .referrer("").get();
            String sHtml = document.html();

            //System.out.println(sHtml);
        }catch (IOException e ){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
