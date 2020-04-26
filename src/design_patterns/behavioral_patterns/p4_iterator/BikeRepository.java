package design_patterns.behavioral_patterns.p4_iterator;

import java.util.Iterator;

public class BikeRepository implements Iterable<String> {
    private static final int DEFAULT_CAPACITY = 4;

    private String[] bikes;
    private int index;

    public BikeRepository() {
        bikes = new String[DEFAULT_CAPACITY];
        index = 0;
    }

    public void addBike(String bike) {
        if (index == bikes.length) {
            // Resize
            String[] newBikes = new String[bikes.length * 2];
            System.arraycopy(bikes, 0, newBikes, 0, bikes.length);
            bikes = newBikes;
            newBikes = null;
        }

        bikes[index++] = bike;
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = new Iterator<String>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < index;
            }

            @Override
            public String next() {
                return bikes[currentIndex++];
            }
        };
        return it;
    }
}
