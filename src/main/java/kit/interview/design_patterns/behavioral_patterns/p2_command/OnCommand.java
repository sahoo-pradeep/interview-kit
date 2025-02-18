package kit.interview.design_patterns.behavioral_patterns.p2_command;

// Concrete Command
public class OnCommand implements Command {
    private Light light;

    public OnCommand(Light light){
     this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
