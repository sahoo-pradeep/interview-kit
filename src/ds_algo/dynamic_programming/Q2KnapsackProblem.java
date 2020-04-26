package ds_algo.dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Link: https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0/?track=md-dp&batchId=144
Video: https://www.youtube.com/watch?v=nLmhmB6NzcM
Video: https://www.youtube.com/watch?v=zRza99HPvkQ
Input:
2
3
4
1 2 3
4 3 1
2
3
1 2
3 4

Output:
3
1
 */
public class Q2KnapsackProblem {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(br.readLine());
            int capacity = Integer.parseInt(br.readLine());
            String[] valueString = br.readLine().trim().split("\\s+");
            String[] weightString = br.readLine().trim().split("\\s+");
            // Adding zero at 0th index
            int[] values = new int[size + 1];
            int[] weights = new int[size + 1];

            values[0] = 0;
            weights[0] = 0;

            for (int v = 1; v < size + 1; v++) {
                values[v] = Integer.parseInt(valueString[v-1]);
                weights[v] = Integer.parseInt(weightString[v-1]);
            }

            int result = solve(size, capacity, values, weights);
            System.out.println(result);
        }
    }

    private static int solve(int size, int capacity, int[] values, int[] weights) {
        int[][] result = new int[size + 1][capacity + 1];

        for (int i = 0; i <= size; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    // Case 1: 0th row/column
                    result[i][w] = 0;
                } else if (weights[i] <= w) {
                    // Case 2: Item at i has weight <= w. i.e. We can add this item in bag
                    // Check if the value increases if we include this item
                    // If we add this item, remaining weight that we can add is:
                    // current capacity (w) - item weight
                    // If we don't add this item, check the value without this item and for same capacity.
                    // i.e. result[i-1][w]
                    result[i][w] =
                            Math.max(values[i] + result[i - 1][w - weights[i]], result[i - 1][w]);
                } else {
                    // Case 3: We can't include this item because it's weight exceeds current capacity (w)
                    result[i][w] = result[i - 1][w];
                }
            }
        }

        return result[size][capacity];
    }
}
