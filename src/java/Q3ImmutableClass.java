package java;

import java.util.HashMap;
import java.util.Map;

public class Q3ImmutableClass {
    public static void main(String[] args) {
        int i = 10;
        String str = "aaa";
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "One");
        map.put("2", "Two");

        ImmutableClass obj = new ImmutableClass(i, str, map);

        System.out.println("i: " + (i == obj.getI()));
        System.out.println("str: " + (str == obj.getStr()));
        System.out.println("map: " + (map == obj.getMap()));

        map.put("3", "Third");
        obj.getMap().put("4", "Four");

        System.out.println("After putting values" + obj.getMap());
    }

    // 1. Declare the 'class as final' so it can't be extended
    public static final class ImmutableClass {
        // 2. Make all 'fields private' so that direct access is not allowed
        // 3. Make all 'fields final' so that it can't be changed once assigned
        private final int i;
        private final String str;
        private final HashMap<String, String> map;

        // 4. Initialize all 'fields via constructor' performing 'deep copy'
        public ImmutableClass(int i, String str, HashMap<String, String> map) {
            this.i = i;
            this.str = str;
            //this.map = map;
            this.map = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.map.put(entry.getKey(), entry.getValue());
            }
        }

        // 5. Don't provide setters. Only getters
        public int getI() {
            return i;
        }

        public String getStr() {
            return str;
        }

        // 6. Perform 'cloning of 'object' to return a copy
        public HashMap<String, String> getMap() {
            //return map;
            return (HashMap<String, String>) this.map.clone();
        }
    }
}
