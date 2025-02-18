package kit.interview.design_patterns.behavioral_patterns.p7_observer;

public class TabletClient extends Observer {

    public TabletClient(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    public void addMessage(String message) {
        subject.setState(message + " - sent from tablet");
    }

    @Override
    public void update() {
        System.out.println("Tablet Stream - " + subject.getState());
    }
}
