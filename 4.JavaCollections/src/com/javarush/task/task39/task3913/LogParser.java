package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.Log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// Класс, который будет отвечать за парсинг

public class LogParser implements IPQuery {

    private Path logDir;
    private List<Log> logs = new ArrayList<>();
    private Pattern pattern = Pattern.compile("(?<ip>[\\d]+.[\\d]+.[\\d]+.[\\d]+)\\s(?<userName>[a-zA-Z ]+)\\s(?<date>[\\d]+.[\\d]+.[\\d]+ [\\d]+:[\\d]+:[\\d]+)\\s(?<event>[\\w]+)\\s?((?<numberEvent>[\\d]+)|)\\s(?<status>[\\w]+)");
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");


    //конструктор с параметром Path logDir, где logDir - директория с логами
    // (логов может быть несколько, все они должны иметь расширение log).
    public LogParser(Path logDir) {
        this.logDir = logDir;
    }



    private List<String> listLog() {
        List<String> stringList = new ArrayList<>();
        File[] files = logDir.toFile().listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".log")) {
                    try {
                        stringList.addAll(Files.readAllLines(file.toPath()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return stringList;
    }
    /*
     * Здесь и далее, если в методе есть параметры Date after и Date before,
     * то нужно возвратить данные касающиеся только данного периода (включая даты after и before).
     *
     * Если параметр after равен null, то нужно обработать все записи,
     * у которых дата меньше или равна before.
     *
     * Если параметр before равен null, то нужно обработать все записи,
     * у которых дата больше или равна after.
     *
     * Если и after, и before равны null,
     * то нужно обработать абсолютно все записи (без фильтрации по дате).
     * */

    private void parseLog() throws ParseException {
        for (String line : listLog()) {
            Matcher matcher = pattern.matcher(line);
            matcher.find();

            String ip = matcher.group("ip");
            String userName = matcher.group("userName");

            Date date = sdf.parse(matcher.group("date"));
            Event event = Event.valueOf(matcher.group("event"));

            int numberEvent;
            if (matcher.group("numberEvent") != null) {
                numberEvent = Integer.parseInt(matcher.group("numberEvent"));
            } else {
                numberEvent = 0;
            }

            Status status = Status.valueOf(matcher.group("status"));

            Log log;
            if (numberEvent != 0) {
                log = new Log(ip, userName, date, event, numberEvent, status);
            } else {
                log = new Log(ip, userName, date, event, status);
            }
            logs.add(log);
        }
    }

    //должен возвращать количество уникальных IP адресов за выбранный период.
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return (int) logs.stream()
                .filter(log -> (after == null || (log.date.getTime() >= after.getTime()))
                        && (before == null || log.date.getTime() <= before.getTime()))
                .map(log -> log.ip)
                .distinct()
                .count();
    }

    //должен возвращать множество, содержащее все не повторяющиеся IP.
    // Тип в котором будем хранить IP будет String.
    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return logs.stream()
                .filter(log -> (after == null || (log.date.getTime() >= after.getTime()))
                        && (before == null || log.date.getTime() <= before.getTime()))
                .map(log -> log.ip).collect(Collectors.toSet());
    }

    //должен возвращать IP, с которых работал переданный пользователь.
    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    //должен возвращать IP, с которых было произведено переданное событие.
    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    //должен возвращать IP, события с которых закончилось переданным статусом.
    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }


}