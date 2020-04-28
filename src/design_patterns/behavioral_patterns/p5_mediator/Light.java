package design_patterns.behavioral_patterns.p5_mediator;

// Receiver
public class Light {
    private final String name;
    private boolean on;

    public Light(String name) {
        this.name = name;
        this.on = false;
    }

    public boolean isOn(){
        return on;
    }

    public void toggle() {
        if (on) {
            off();
            on = false;
        } else {
            on();
            on = true;
        }
    }

    private void on() {
        System.out.println(name + " Light On");
    }

    private void off() {
        System.out.println(name + " Light Off");
    }
}
