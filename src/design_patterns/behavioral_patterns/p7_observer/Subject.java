package design_patterns.behavioral_patterns.p7_observer;

import java.util.ArrayList;
import java.util.List;

// Observable
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    public abstract void setState(String state);

    public abstract String getState();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void deleteObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for(Observer observer: observers){
            observer.update();
        }
    }
}
