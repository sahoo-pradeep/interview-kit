package design_patterns.oops;

// Abstraction: hiding the actual implementation - showing only necessary features to the outside world.
// Advantage: reduce complexity of a program
// Eg: In Java, abstraction is achieved by Abstract class and Interface.
public class P1Abstraction {

    public static void main(String[] args) {
        AbstractTV tv = new LedTV();
        tv.powerOn();
        tv.powerOff();
    }


    abstract static class AbstractTV {
        public abstract void powerOn();
        public abstract void powerOff();
    }

    static class LedTV extends AbstractTV{
        @Override
        public void powerOn() {
            System.out.println("Turning On TV");
        }

        @Override
        public void powerOff() {
            System.out.println("Turning Off TV");
        }
    }
}
