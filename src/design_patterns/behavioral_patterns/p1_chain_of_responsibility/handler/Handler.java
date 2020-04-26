package design_patterns.behavioral_patterns.p1_chain_of_responsibility.handler;

import design_patterns.behavioral_patterns.p1_chain_of_responsibility.Request;

public abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(Request request);
}
