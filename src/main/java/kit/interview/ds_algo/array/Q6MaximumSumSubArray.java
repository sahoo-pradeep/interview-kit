package kit.interview.ds_algo.array;

/*
Link: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
Largest Sum Contiguous Sub-array: Write an efficient program to find the sum of contiguous
sub-array within a one-dimensional array of numbers which has the largest sum.
 */
public class Q6MaximumSumSubArray {
    public static void main(String[] args) {
        int[] input = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solve(input));
    }

    private static int solve(int[] input) {
        int maxEndingHere = 0;
        int maxSoFar = Integer.MIN_VALUE;

        for (int i : input) {

            maxEndingHere = maxEndingHere + i;
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }
}
