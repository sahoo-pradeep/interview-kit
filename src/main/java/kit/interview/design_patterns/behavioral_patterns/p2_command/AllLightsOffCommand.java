package kit.interview.design_patterns.behavioral_patterns.p2_command;

import java.util.List;

public class AllLightsOffCommand implements Command {
    List<Light> lights;

    public AllLightsOffCommand(List<Light> lights) {
        this.lights = lights;
    }

    @Override
    public void execute() {
        for (Light light: lights){
            if (light.isOn()){
                light.off();
            }
        }
    }
}
