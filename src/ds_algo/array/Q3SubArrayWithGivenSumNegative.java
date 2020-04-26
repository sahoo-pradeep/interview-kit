package ds_algo.array;

import java.util.HashMap;
import java.util.Map;

/*
Link: https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
Find sub-array with given sum (Handles Negative Numbers): Given an unsorted array of integers,
find a sub-array which adds to a given number. If there are more than one subarrays with the sum
as the given number, print any of them.

*/
public class Q3SubArrayWithGivenSumNegative {
    public static void main(String[] args) {
        int[] input = new int[] {10, 2, -2, -20, 10};
        int sum = -10; //Try with 0 for check2
        solve(input.length, sum, input);
    }

    private static void solve(int size, int sum, int[] input) {
        Map<Integer, Integer> map = new HashMap<>();
        int curr_sum = 0;

        for (int i = 0; i < size; i++) {
            curr_sum += input[i];
            if (curr_sum == sum) {
                System.out.println("Check1");
                System.out.println("Result:" + 0 + " " + i);
                return;
            }
            if (map.get(curr_sum - sum) != null) {
                System.out.println("Check2");
                System.out.println("Result:" + map.get(curr_sum - sum) + " " + i);
                return;
            }
            System.out.println("Update");
            map.put(curr_sum, i);
        }
        System.out.println("No such sub-array exists");
    }
}
