package kit.interview.java_problems.basic_interview;

import java_problems.utils.Clock;

public class StringConcat {
    public static void main(String[] args) {
        int loopCount = 60_000;

        Clock stringClock = new Clock();
        String string = "";
        for (int i = 0; i < loopCount; i++){
            string = string + "*";
        }
        System.out.println(stringClock.getElapsedTime());

        Clock stringBuilderClock = new Clock();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < loopCount; i++){
            stringBuilder.append("*");
        }
        stringBuilder.toString();
        System.out.println(stringBuilderClock.getElapsedTime());
    }
}
