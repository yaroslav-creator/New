package com.javarush.task.task27.task2712.ad;


import java.util.ArrayList;
import java.util.List;

//- хранилище рекламных роликов.
public class AdvertisementStorage {

    private static AdvertisementStorage ourInstance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();

        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 5 * 60)); //5 min
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
        videos.add(new Advertisement(someContent, "Четвертое видео", 150, 2, 15 * 60));//15 min
    }

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    // Метод,который вернет список всех существующих доступных видео.
    public List<Advertisement> list() {
        return videos;
    }

    //Метод,который добавит новое видео в список videos.
    public void add(Advertisement advertisement) {
        videos.add( advertisement );
    }
}