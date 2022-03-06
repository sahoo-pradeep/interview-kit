package ds_algo.dynamic_programming.knapsack;

/*
Refs:
https://www.geeksforgeeks.org/partition-problem-dp-18/
 */

import java.util.Arrays;

public class Q3_EqualSumPartition {
    public static void main(String[] args) {
        int[] input = {1, 5, 11, 5};
        boolean result = equalSumPartitionExists(input);
        System.out.println(result);
    }

    private static boolean equalSumPartitionExists(int[] input) {
        int sum = Arrays.stream(input).sum();
        // if total sum is odd, not possible
        if (sum % 2 != 0) {
            return false;
        }

        return Q2_SubsetSum.subsetSumExists(input, sum / 2, input.length);
    }
}
