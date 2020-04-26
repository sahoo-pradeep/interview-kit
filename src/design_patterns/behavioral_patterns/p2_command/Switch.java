package design_patterns.behavioral_patterns.p2_command;

// Invoker
public class Switch {
    public void storeAndExecute(Command command){
        command.execute();
    }
}
