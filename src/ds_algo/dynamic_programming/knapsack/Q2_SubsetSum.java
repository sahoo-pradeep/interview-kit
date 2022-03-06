package ds_algo.dynamic_programming.knapsack;

/*
Ref:
- https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
- https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7&ab_channel=AdityaVerma
 */
public class Q2_SubsetSum {
    public static void main(String[] args) {
        int[] input = {2, 3, 7, 8, 10};
        int sum = 11;

        boolean result = subsetSumExists(input, sum, input.length);
        System.out.println(result);
    }

    public static boolean subsetSumExists(int[] input, int sum, int size) { // sum = 11, size = 5
        // subset = []
        if (sum == 0) {
            return true;
        }

        // input = []. sum != 0. subset not possible
        if (size == 0) {
            return false;
        }

        if (input[size - 1] <= sum) {
            return subsetSumExists(input, sum - input[size - 1], size - 1) || subsetSumExists(input, sum, size-1);
        } else {
            return subsetSumExists(input, sum, size - 1);
        }
    }
}
