package java_problems.basic_interview;

import java.util.HashMap;
import java.util.Map;

public class ImmutableClient {
    public static void main(String[] args) {
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);

        ImmutableClass ic = new ImmutableClass(map1);
        map1.put("B", 2);

        Map<String, Integer> map2 = ic.getMap();
        map2.put("C", 3);

        System.out.println(ic.getMap().get("A"));
        System.out.println(ic.getMap().get("B"));
        System.out.println(ic.getMap().get("C"));
    }

    //TODO: make this class immutable
    private static class ImmutableClass {
        public Map<String, Integer> map;

        public ImmutableClass(Map<String, Integer> map) {
            this.map = map;
        }

        public Map<String, Integer> getMap() {
            return map;
        }
    }
}