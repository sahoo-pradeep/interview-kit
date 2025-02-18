package kit.interview.design_patterns.behavioral_patterns.p1_chain_of_responsibility.handler;

import kit.interview.design_patterns.behavioral_patterns.p1_chain_of_responsibility.Request;

public class Director extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals(Request.RequestType.CONFERENCE)) {
            System.out.println("Directors can approve Conferences");
            System.out.println("Director approving " + request.getRequestType().name() + " of amount: " + request.getAmount());
        } else {
            successor.handleRequest(request);
        }
    }
}
