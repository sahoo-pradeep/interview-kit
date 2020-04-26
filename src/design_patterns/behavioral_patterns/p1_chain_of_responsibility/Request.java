package design_patterns.behavioral_patterns.p1_chain_of_responsibility;

public class Request {
    public enum RequestType {
        CONFERENCE, PURCHASE
    }


    private RequestType requestType;
    private long amount;

    public Request(RequestType requestType, long amount) {
        this.requestType = requestType;
        this.amount = amount;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public long getAmount() {
        return amount;
    }
}
