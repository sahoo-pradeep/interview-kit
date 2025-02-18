package kit.interview.design_patterns.behavioral_patterns.p5_mediator;

// concrete command
public class TurnOnAllLightsCommand implements Command {
    private Mediator mediator;

    public TurnOnAllLightsCommand(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void execute() {
        mediator.turnOnAllLights();
    }
}
