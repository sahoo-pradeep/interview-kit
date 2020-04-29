package design_patterns.behavioral_patterns.p7_observer;

import java.util.Deque;
import java.util.LinkedList;

// Concrete Observable
public class MessageStream extends Subject {
    // Using as a stack
    private Deque<String> messageHistory = new LinkedList<>();

    @Override
    public void setState(String state) {
        messageHistory.offer(state);
        this.notifyObservers();
    }

    @Override
    public String getState() {
        return messageHistory.getLast();
    }
}
