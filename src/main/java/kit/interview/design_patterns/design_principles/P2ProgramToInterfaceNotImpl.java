package kit.interview.design_patterns.design_principles;

// Program to an Interface, not an Implementation: Program to an interface, not an implementation.
// Depend on abstractions, not on concrete classes.
// The design is flexible enough if you can easily extend it without breaking any existing code.
public class P2ProgramToInterfaceNotImpl {
    public static void main(String[] args) {
        System.out.println("Human Old");
        HumanOld humanOld = new HumanOld();
        humanOld.drive(new MarutiSuzuki());

        System.out.println("Human New");
        HumanNew humanNew = new HumanNew();
        humanNew.drive(new MarutiSuzuki());
        humanNew.drive(new Ferrari());
    }

    private static class HumanOld {
        // Here, drive is dependent on Implementation of MarutiSuzuki.
        // Human cannot drive any other car than MarutiSuzuki
        void drive(MarutiSuzuki marutiSuzuki) {
            marutiSuzuki.engineOn();
            marutiSuzuki.accelerate();
        }
    }


    private static class HumanNew {
        // Program to interface. Now human can drive any car which implements Car interface.
        void drive(Car car) {
            car.engineOn();
            car.accelerate();
        }
    }


    interface Car {
        void engineOn();

        void accelerate();

        void brake();
    }


    // MarutiSuzuki Implementing Car
    private static class MarutiSuzuki implements Car {
        public void engineOn() {
            System.out.println("MarutiSuzuki Engine On");
        }

        public void accelerate() {
            System.out.println("MarutiSuzuki accelerate");
        }

        public void brake() {
            System.out.println("MarutiSuzuki brake");
        }
    }


    // Ferrari Implementing Car
    private static class Ferrari implements Car {
        @Override
        public void engineOn() {
            System.out.println("Ferrari Engine On");
        }

        public void accelerate() {
            System.out.println("Ferrari accelerate");
        }

        public void brake() {
            System.out.println("Ferrari brake");
        }
    }
}
