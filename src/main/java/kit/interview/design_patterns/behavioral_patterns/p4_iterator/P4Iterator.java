package kit.interview.design_patterns.behavioral_patterns.p4_iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
Concepts:
1. Traverse a container (collection)
2. Don't expose underlying structure
3. Decouples data and iteration algorithm
4. Sequential
5. Concurrent modification

Examples:
1. java.util.Iterator

Design:
1. Interface based
2. Factory Method based.
3. Iterator, ConcreteIterator

Pitfalls:
1. No access to index
2. Uni-directional (Some provides forward and backward iteration. Eg. ListIterator)
3. Sometimes slower. But for large collection, it is efficient
 */
public class P4Iterator {
    public static void main(String[] args) {
        BikeRepository bikeRepository = new BikeRepository();
        bikeRepository.addBike("Hunk");
        bikeRepository.addBike("Pulsar");
        bikeRepository.addBike("Royal Enfield");

        System.out.println("### Iterator ###");
        Iterator<String> iterator = bikeRepository.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("\n### Enhanced For Loop ###");
        for (String bike: bikeRepository){
            System.out.println(bike);
        }
    }

    private static void javaExample(){
        List<String> names = new ArrayList<>();
        names.add("Pradeep");
        names.add("Kumar");
        names.add("Sahoo");

        System.out.println("### For Loop ###");
        for (int i = 0; i < names.size(); i++){
            System.out.println(names.get(i));
            // We cannot loop over set using this method
            // We can remove an element in for loop. It cause restructuring of array.
            // names.remove(i);
        }

        System.out.println("\n### For Each Loop ###");
        // Internally foreach is using Iterator
        for (String name: names){
            System.out.println(name);
            // Can't remove in foreach loop: ConcurrentModificationException
            //names.remove(name);
        }

        System.out.println("\n### Loop using Iterator ###");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            // We can remove the current element.
            // iterator.remove();
        }
    }
}
