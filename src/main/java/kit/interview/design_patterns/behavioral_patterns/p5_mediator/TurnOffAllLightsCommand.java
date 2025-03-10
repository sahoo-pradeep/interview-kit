package kit.interview.design_patterns.behavioral_patterns.p5_mediator;

public class TurnOffAllLightsCommand implements Command {
    private Mediator mediator;

    public TurnOffAllLightsCommand(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void execute() {
        mediator.turnOffAllLights();
    }
}
