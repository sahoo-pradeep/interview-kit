package design_patterns.behavioral_patterns.p1_chain_of_responsibility.handler;

import design_patterns.behavioral_patterns.p1_chain_of_responsibility.Request;

public class VP extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.getRequestType().equals(Request.RequestType.PURCHASE)) {
            if (request.getAmount() < 10_000) {
                System.out.println("VP can handle purchase upto 10,000");
                System.out.println("VP approving " + request.getRequestType().name() + " of amount: " + request.getAmount());
            } else {
                successor.handleRequest(request);
            }
        }
    }
}
