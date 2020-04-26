package design_patterns.behavioral_patterns.p1_chain_of_responsibility;

import design_patterns.behavioral_patterns.p1_chain_of_responsibility.handler.CEO;
import design_patterns.behavioral_patterns.p1_chain_of_responsibility.handler.Director;
import design_patterns.behavioral_patterns.p1_chain_of_responsibility.handler.VP;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Concepts:
1. Decoupling of send and receiver
2. Receiver contains reference to next receiver
3. Promotes loose coupling
4. Hierarchical in nature

Examples:
1. java.util.logging.Logger.log()
2. Spring Security Filter Chain

Design:
1. Chain of receiver objects
2. Handler is interface based.
3. Concrete Handler for each implementation
4. Each handler has reference to next

Pitfalls:
1. No handling/handler guarantee that our request will be handled
2. Runtime configuration risk
3. Chain length - performance issue
4.
 */
public class P1ChainOfResponsibility {
    private static final Logger logger = Logger.getLogger(P1ChainOfResponsibility.class.getName());

    public static void main(String[] args) {
        Director director = new Director();
        VP vp = new VP();
        CEO ceo = new CEO();

        director.setSuccessor(vp);
        vp.setSuccessor(ceo);

        Request conf = new Request(Request.RequestType.CONFERENCE, 1_000);
        Request purchase5000 = new Request(Request.RequestType.PURCHASE, 5_000);
        Request purchase20000 = new Request(Request.RequestType.PURCHASE, 20_000);

        director.handleRequest(conf);
        director.handleRequest(purchase5000);
        director.handleRequest(purchase20000);
    }

    private static void javaExample() {
        // level to log at
        logger.setLevel(Level.FINEST);

        ConsoleHandler handler = new ConsoleHandler();
        //level to publish at
        handler.setLevel(Level.FINER);
        logger.addHandler(handler);

        logger.finest("Finest Level");
        logger.finer("Finer Level");
        logger.fine("Fine Level");
    }
}
