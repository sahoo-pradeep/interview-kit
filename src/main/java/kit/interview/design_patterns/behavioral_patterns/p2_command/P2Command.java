package kit.interview.design_patterns.behavioral_patterns.p2_command;

import java.util.ArrayList;
import java.util.List;

/*
Concepts:
1. Encapsulate request as Object
2. Object oriented callback
3. Decouple sender and receiver
4. Undo functionality

Examples:
1. java.lang.Runnable
2. javax.swing.Action

Design:
1. Object per command (therefore, object is verb here)
2. Command Interface with execute method.
3. For undo, it can contain undo() or unexecute() method. Done using Reflection

Pitfalls:
1. Multiple Commands
2. Dependency on other patterns
3. To store history or undo feature - use Prototype
 */
public class P2Command {
    public static void main(String[] args) {
        Light bedroomLight = new Light("Bedroom");
        Light kitchenLight = new Light("Kitchen");
        Light hallLight = new Light("Hall");
        Switch lightSwitch = new Switch();

        // Switch
        System.out.println("V1. Switch:");
        Command onCommand = new OnCommand(bedroomLight);
        Command offCommand = new OffCommand(bedroomLight);
        lightSwitch.storeAndExecute(onCommand);
        lightSwitch.storeAndExecute(offCommand);

        // Storing state
        System.out.println("\nV2. State:");
        Command toggle = new ToggleCommand(bedroomLight);
        lightSwitch.storeAndExecute(toggle);
        lightSwitch.storeAndExecute(toggle);
        lightSwitch.storeAndExecute(toggle);

        // Macro - Switch on or off all lights
        System.out.println("\nV3. Macro:");
        List<Light> lights = new ArrayList<>();
        lights.add(bedroomLight);
        lights.add(kitchenLight);
        lights.add(hallLight);
        Command allLightsOffCommand = new AllLightsOffCommand(lights);

        lightSwitch.storeAndExecute(new ToggleCommand(hallLight));
        lightSwitch.storeAndExecute(allLightsOffCommand);
    }

    private static void javaExample() {
        Runnable runnable = () -> System.out.println("Inside Runnable"); // run() = execute method
        Thread t = new Thread(runnable);
        t.start(); // start() = invoker
    }
}
