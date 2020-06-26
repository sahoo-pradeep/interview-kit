package java_problems.utils;

import java.time.Duration;

public class Clock {
    private final long start;
    public Clock(){
        start = System.currentTimeMillis();
    }

    public long getElapsedTime(){
        return System.currentTimeMillis() - start;
    }

    public String getElapsedTimeFormatted(){
        long elapsedTime = System.currentTimeMillis() - start;
        Duration elapsedDuration = Duration.ofMillis(elapsedTime);
        return elapsedDuration.toString();
    }
}
