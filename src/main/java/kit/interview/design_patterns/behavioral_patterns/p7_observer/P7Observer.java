package kit.interview.design_patterns.behavioral_patterns.p7_observer;

import java.util.Observable;
import java.util.Observer;

/*
Concepts:
1. Subject has One-to-Many observers.
2. Event handling capabilities
3. Publisher Subscriber

Examples:
1. java.util.Observer
2. java.util.EventListener
3. javax.jms.Topic

Design:
1. Subject needs to Observe. Usually an interface. Have multiple impl.
2. Observers register themselves with Subject. Usually an interface. Have multiple impl.
3. Observable: the subject extends observable.

Pitfalls:
1. Unexpected updates. since, subject do not know about observers
2. Large update consequences
3. difficult debugging

 */
public class P7Observer {
    public static void main(String[] args) {
        Subject messageStream = new MessageStream();

        PhoneClient phoneClient = new PhoneClient(messageStream);
        TabletClient tabletClient = new TabletClient(messageStream);

        phoneClient.addMessage("Message 1");
        tabletClient.addMessage("New Message");
    }

    // new P7Observer().javaExample();
    private void javaExample(){
        TwitterStream twitterStream = new TwitterStream();

        Client mark = new Client("Mark");
        Client bill = new Client("Bill");

        twitterStream.addObserver(mark);
        twitterStream.addObserver(bill);

        twitterStream.someoneTweeted();
    }
}

// concrete subject
class TwitterStream extends Observable {
    public void someoneTweeted(){
        setChanged();
        notifyObservers();
    }
}
// concrete observer
class Client implements Observer {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update " + name + "'s tweet.");
    }
}
