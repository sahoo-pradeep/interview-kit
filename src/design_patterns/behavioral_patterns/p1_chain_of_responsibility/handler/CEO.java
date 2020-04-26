package design_patterns.behavioral_patterns.p1_chain_of_responsibility.handler;

import design_patterns.behavioral_patterns.p1_chain_of_responsibility.Request;

public class CEO extends Handler {
    @Override
    public void handleRequest(Request request) {
        System.out.println("CEO can handle anything");
        System.out.println("CEO approving " + request.getRequestType().name() + " of amount: " + request.getAmount());
    }
}
