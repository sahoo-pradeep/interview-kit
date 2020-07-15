package java_problems.basic_interview;

import java.util.HashMap;

public class ImmutableClient {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        ImmutableClass ic = new ImmutableClass(map);

        map.put("B", 2);

        HashMap<String, Integer> mapFromImmutable = ic.getMap();
        mapFromImmutable.put("C", 3);

        //test
        if (ic.getMap().get("B") != null){
            throw new AssertionError("Error: Map shouldn't contain key B");
        }

        if (ic.getMap().get("C") != null){
            throw new AssertionError("Error: Map shouldn't contain key C");
        }
    }
}

//TODO: make this class immutable
class ImmutableClass {
    public HashMap<String, Integer> map;

    public ImmutableClass(HashMap<String, Integer> map) {
        this.map = map;
    }

    public HashMap<String, Integer> getMap() {
        return map;
    }
}