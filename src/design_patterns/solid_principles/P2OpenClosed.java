package design_patterns.solid_principles;

// Open/Closed Principle: Classes should be open for extension but closed for modification.
// A class is 'open' when we can create subclass of it, add methods, overriding existing logic, etc
// A class is 'closed' when it is completed, i.e., 100% ready to be used by other classes -  its
// interface is fully defined and won't change in future.
public class P2OpenClosed {
    private static class OrderV1 {
        private String shipping;

        // For every new shipping, we need to modify the code.
        // Solve this problem using Strategy pattern - extract shipping methods to separate class
        //
        private int getShippingCost() {
            if (shipping.equals("GROUND")) {
                return 100;
            } else if (shipping.equals("AIR")) {
                return 500;
            }
            return 0;
        }
    }

    // This code is not changed when new shipping method is introduced. say, SeaShipping
    private static class OrderV2 {
        private Shipping shipping;

        private int getShippingCost() {
            return shipping.getCost();
        }
    }

    // Add a new class implementing Shipping Interface
    interface Shipping {
        int getCost();
    }


    private static class GroundShipping implements Shipping {
        @Override
        public int getCost() {
            return 100;
        }
    }


    private static class AirShipping implements Shipping {
        @Override
        public int getCost() {
            return 500;
        }
    }
}
