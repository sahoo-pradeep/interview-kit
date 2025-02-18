package kit.interview.design_patterns.behavioral_patterns.p7_observer;

// Observer
public abstract class Observer {
    // Diff from java Observer -> storing Subject
    protected Subject subject;

    public abstract void update();
}
