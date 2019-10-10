package com.javarush.task.task39.task3913.query;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Status;

import java.util.Date;

public class Log {
    public String ip;
    public String userName;
    public Date date;
    public Event event;
    public int numberEvent;
    public Status status;
//    public SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


    public Log(String ip, String userName, Date date, Event event, int numberEvent, Status status) {
        this.ip = ip;
        this.userName = userName;
        this.date = date;
        this.event = event;
        this.numberEvent = numberEvent;
        this.status = status;
    }

    public Log(String ip, String userName, Date date, Event event, Status status) {
        this.ip = ip;
        this.userName = userName;
        this.date = date;
        this.event = event;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public String getUserName() {
        return userName;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public int getNumberEvent() {
        return numberEvent;
    }

    public Status getStatus() {
        return status;
    }
}
