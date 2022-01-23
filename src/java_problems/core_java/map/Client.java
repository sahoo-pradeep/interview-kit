package java_problems.core_java.map;

public class Client {
    public static void main(String[] args) {
        TestMap<String, Integer> map = new TestMapImpl<>();
        System.out.println(map.size() == 0);
        System.out.println(map.isEmpty());
        System.out.println(map.get("Dev") == null);
        System.out.println(map.remove("Dev") == null);
        System.out.println(!map.containsKey("Dev"));

        map.put("Dev", 5);
        map.put("QA", 2);

        System.out.println(map.size() == 2);
        System.out.println(!map.isEmpty());
        System.out.println(map.get("Dev") == 5);
        System.out.println(map.get("QA") == 2);
        System.out.println(map.remove("QA") == 2);
        System.out.println(map.size() == 1);
        System.out.println(map.containsKey("Dev"));
    }
}
