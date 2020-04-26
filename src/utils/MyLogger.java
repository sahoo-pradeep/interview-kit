package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {
    public static void log(Object message){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = LocalDateTime.now().format(formatter);
        message = message == null ? "null" : message;
        System.out.println(time + ": " + message.toString());
    }
}
