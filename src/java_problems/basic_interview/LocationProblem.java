package java_problems.basic_interview;

import java.util.*;

// Conditions:
// 1. Two locations with same city and state are treated as same location.
// eg. mumbai and mumbai2 are same location because both have city = MUMBAI and state = MAHARASHTRA
// 2. if we get the same location again, update the pickup and delivery value.
// Final output - [MUMBAI, MAHARASHTRA, true, true], [BENGALURU, KARNATAKA, true, false]
public class LocationProblem {
    private static final String MUMBAI = "Mumbai";
    private static final String MAHARASHTRA = "Maharashtra";
    private static final String BENGALURU = "Bengaluru";
    private static final String KARNATAKA = "Karnataka";

    public static void main(String[] args) {
        Location mumbai = new Location(MUMBAI, MAHARASHTRA, false, false);
        Location bengaluru = new Location(BENGALURU, KARNATAKA, true, true);
        Location bengaluru2 = new Location(BENGALURU, KARNATAKA, false, true);
        Location bengaluru3 = new Location(BENGALURU, KARNATAKA, true, false);
        Location mumbai2 = new Location(MUMBAI, MAHARASHTRA, true, true);

        List<Location> inputLocations = new ArrayList<>();
        inputLocations.add(mumbai);
        inputLocations.add(bengaluru);
        inputLocations.add(bengaluru2);
        inputLocations.add(bengaluru3);
        inputLocations.add(mumbai2);
        System.out.println("Input:");
        System.out.println(inputLocations);

        List<Location> outputLocations = processLocations(inputLocations);
        System.out.println("Output:");
        System.out.println(outputLocations);
    }

    public static List<Location> processLocations(List<Location> inputLocations){
        // TODO: write Code
        return null;
    }

    public static void copy(List<Location> inputLocations){
        //TODO: Create a new List - Shallow copy

        //TODO: Create a new List - Deep Copy
    }
}

class Location {
    String city;
    String state;
    boolean pickup;
    boolean delivery;

    public Location(String city, String state, boolean pickup, boolean delivery) {
        this.city = city;
        this.state = state;
        this.pickup = pickup;
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",\t", "\n[", "]");
        joiner.add(city);
        joiner.add(state);
        joiner.add(String.valueOf(pickup));
        joiner.add(String.valueOf(delivery));
        return joiner.toString();
    }
}
