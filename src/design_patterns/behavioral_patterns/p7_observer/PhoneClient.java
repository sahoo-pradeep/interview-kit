package design_patterns.behavioral_patterns.p7_observer;

// Concrete impl of Observer
public class PhoneClient extends Observer {

    public PhoneClient(Subject subject) {
        this.subject = subject;
        subject.addObserver(this);
    }

    public void addMessage(String message){
        subject.setState(message + " - sent from phone");
    }

    @Override
    public void update() {
        System.out.println("Phone Stream - " + subject.getState());
    }
}
