package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class MyLogger {
    private static final String DATA_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static boolean includeThread = true;

    public static void log(Object message){
        message = message == null ? "null" : message;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATA_TIME_FORMAT);
        String dateTime = LocalDateTime.now().format(formatter);

        String threadName = Thread.currentThread().getName();

        StringJoiner stringJoiner = new StringJoiner(" - ", "Log: ", "");
        if (includeThread){
            stringJoiner.add(threadName);
        }

        stringJoiner.add(dateTime);
        stringJoiner.add(message.toString());

        System.out.println(stringJoiner);
    }
}
