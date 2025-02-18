package kit.interview.design_patterns.structural_patterns.p1_adapter;

import java.util.Arrays;
import java.util.List;

/*
Concepts:
1. Connect new code to legacy code without changing contract.
2. Client, Adapter, Legacy class
3. Multiple adapters

Examples:
1. Arrays -> Lists
2. Streams

Design:
1. Client centric
2. Integrate new with old

Pitfalls:
1. Don't add functionality (use Decorator for that)
 */
public class P1Adapter {
    public static void main(String[] args) {
        EmployeeClient client = new EmployeeClient();
        List<Employee> employees = client.getEmployees();
        System.out.println(employees);
    }

    // new P1Adapter().javaExample();
    public void javaExample(){
        // Adapting an array to List
        Integer[] arrayOfInts = new Integer[]{1, 2, 3, 4};
        List<Integer> listOfInts = Arrays.asList(arrayOfInts);

        System.out.println(arrayOfInts);
        System.out.println(listOfInts);
    }
}
