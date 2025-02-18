package kit.interview.ds_algo.array;

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
        int[] input = new int[]{10, 2, -2, -20, 10};
        int sum = -10; //Try with 0 for check2
        solve2(input.length, sum, input);
    }

    private static void solve2(int size, int sum, int[] input) {
        Map<Integer, Integer> sumToIndexMap = new HashMap<>(size);
        int sumTillIndex = 0;

        for (int i = 0; i < size; i++) {
            sumTillIndex += input[i];
            if (sumTillIndex == sum) {
                System.out.println("0, " + i);
                return;
            }
            int compositeSum = sum - sumTillIndex;
            if (sumToIndexMap.get(compositeSum) != null) {
                System.out.println(sumToIndexMap.get(compositeSum) + ", " + i);
                return;
            } else {
                sumToIndexMap.put(sumTillIndex, i);
            }
        }

        System.out.println("-1");
    }
}
