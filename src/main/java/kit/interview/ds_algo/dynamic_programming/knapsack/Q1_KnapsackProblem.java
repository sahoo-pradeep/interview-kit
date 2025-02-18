package kit.interview.ds_algo.dynamic_programming.knapsack;

/*
Link: https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
Video(Aditya Verma): https://www.youtube.com/watch?v=l02UxPYRmCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=3&ab_channel=AdityaVerma
 */
public class Q1_KnapsackProblem {
    public static void main(String[] args) throws Exception {
        // Test case 1
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        int sol1 = knapsackMemoization(weights, values, capacity, weights.length);
        int sol1TopDown = knapsackTopDown(weights, values, capacity, weights.length);
        System.out.println("Solution (mem): " + sol1 + " is " + (sol1 == 220));
        System.out.println("Solution (top down): " + sol1TopDown + " is " + (sol1TopDown == 220));

        // Test Case 2
        weights = new int[]{1, 2};
        values = new int[]{3, 4};
        capacity = 2;

        int sol2 = knapsackMemoization(weights, values, capacity, weights.length);
        int sol2TopDown = knapsackTopDown(weights, values, capacity, weights.length);
        System.out.println("Solution (mem): " + sol2 + " is " + (sol2 == 4));
        System.out.println("Solution (top down): " + sol2TopDown + " is " + (sol2TopDown == 4));
    }

    // Solution using memoization
    private static int knapsackMemoization(int[] weights, int[] values, int capacity, int size) {
        if (capacity == 0 || size == 0) {
            return 0;
        }

        if (weights[size - 1] <= capacity) {
            return Math.max(
                    values[size - 1] + knapsackMemoization(weights, values, capacity - weights[size - 1], size - 1),
                    knapsackMemoization(weights, values, capacity, size - 1)
            );
        } else {
            return knapsackMemoization(weights, values, capacity, size - 1);
        }
    }

    /*
    wt: [10, 20, 30]
    val: [60, 100, 120]
    capacity = 50
    table:
     capacity =    0  1  2  3  ..  50
     n = 0      [  0  0  0  0  ..  0
     n = 1         0
     n = 2         0
     n = 3         0

    n = 1
    w = 1
    weights = [10]
    value = [60]
    capacity = 1

     */

    // Solution using top down approach
    private static int knapsackTopDown(int[] weights, int[] values, int capacity, int size) {
        int[][] table = new int[size + 1][capacity + 1];

        for (int i = 0; i < table.length; i++) {
            table[i][0] = 0;
        }

        for (int j = 0; j < table[0].length; j++) {
            table[0][j] = 0;
        }

        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                if (weights[i - 1] <= j) {
                    table[i][j] = Math.max(
                            values[i - 1] + table[i - 1][j - weights[i - 1]],
                            table[i - 1][j]
                    );
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }


        return table[table.length - 1][table[0].length - 1];
    }
}
