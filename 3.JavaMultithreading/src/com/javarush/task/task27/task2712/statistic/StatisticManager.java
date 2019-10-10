package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class StatisticManager {
    private static volatile StatisticManager instance = new StatisticManager();

    private StatisticStorage statisticStorage = new StatisticStorage();

    public static StatisticManager getInstance() {
        if (instance == null) instance = new StatisticManager();
        return instance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put( data );
    }

//    private Set<Cook> cooks = new HashSet<>();
//
//    public void register(Cook cook) {
//        cooks.add( cook );
//    }
//
//    public Set<Cook> getCooks() {
//        return cooks;
//    }

    public Map<LocalDate, Long> getVideos() {

        Map<LocalDate, Long> result = new TreeMap<>( Collections.reverseOrder() );
        List<EventDataRow> videoList = statisticStorage.getSelectedVideo();

        for (EventDataRow event : videoList) {
            LocalDate date = event.getDate().toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
            VideoSelectedEventDataRow videoEvent = (VideoSelectedEventDataRow) event;
            if (!result.containsKey( date ))
                result.put( date, videoEvent.getAmount() );
            else
                result.computeIfPresent( date, (key, value) -> value + videoEvent.getAmount() );
        }
        return result;
    }

    public Map<LocalDate, Map<String, Integer>> getCookWorkloading() {
        Map<LocalDate, Map<String, Integer>> resultMap = new TreeMap<>( Collections.reverseOrder() );
        for (EventDataRow event : statisticStorage.getCookedOrder()) {
            LocalDate date = event.getDate().toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
            CookedOrderEventDataRow eventData = (CookedOrderEventDataRow) event;
            int workTime = eventData.getTime();

            if (resultMap.containsKey( date )) {
                Map<String, Integer> cookInfo = resultMap.get( date );
                if (cookInfo.containsKey( eventData.getCookName() ))
                    cookInfo.put( eventData.getCookName(), cookInfo.get( eventData.getCookName() + workTime ) );
                else cookInfo.put( eventData.getCookName(), workTime );
            } else {
                TreeMap<String, Integer> cookInfo = new TreeMap<>();
                cookInfo.put( eventData.getCookName(), workTime );
                resultMap.put( date, cookInfo );
            }
        }
        return resultMap;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType type : EventType.values())
                storage.put( type, new ArrayList<>() );
        }

        private void put(EventDataRow data) {
            storage.get( data.getType() ).add( data );
        }

        private List<EventDataRow> getSelectedVideo() {
            return storage.get( EventType.SELECTED_VIDEOS );
        }

        private List<EventDataRow> getCookedOrder() {
            return storage.get( EventType.COOKED_ORDER );
        }
    }
}
