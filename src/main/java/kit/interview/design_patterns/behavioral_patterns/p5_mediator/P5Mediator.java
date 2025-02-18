package kit.interview.design_patterns.behavioral_patterns.p5_mediator;

import utils.MyLogger;

import java.util.Timer;
import java.util.TimerTask;

/*
Concepts:
1. Loose coupling
2. Solve complex interactions between objects.
3. Helps in making Object reusable
4. Acts as Hub/Router

Examples:
1. java.util.Timer
2. java.lang.reflect.Method#invoke()

Design:
1. Interface based
2. Concrete class
3. Mediator knows all colleagues, not the other way.

Pitfalls:
1. Mediator class can become large
2. Confusion in Command and Mediator
 */
public class P5Mediator {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Light bedroomLight = new Light("Bedroom");
        Light kitchenLight = new Light("Kitchen");

        // Instead of creating list and passing it, we register the lights
        mediator.registerLight(bedroomLight);
        mediator.registerLight(kitchenLight);

        Command turnOnAllLightsCommand = new TurnOnAllLightsCommand(mediator);
        turnOnAllLightsCommand.execute();

        Command turnOffAllLightCommand = new TurnOffAllLightsCommand(mediator);
        turnOffAllLightCommand.execute();
    }

    // new P5Mediator().javaExample();

    private Timer timer;

    private void javaExample(){
        MyLogger.log("About to schedule task");
        timer = new Timer();
        timer.schedule(new RemindTask(), 2000);
        timer.schedule(new RemindTaskWithoutBeep(), 4000);
        MyLogger.log("Task scheduled");
    }

    class RemindTask extends TimerTask {
        @Override
        public void run() {
            MyLogger.log("Times's Up!");
            MyLogger.log("Beep");
        }
    }

    class RemindTaskWithoutBeep extends TimerTask {
        @Override
        public void run() {
            MyLogger.log("Now time's really up!");
            timer.cancel();
        }
    }

}
