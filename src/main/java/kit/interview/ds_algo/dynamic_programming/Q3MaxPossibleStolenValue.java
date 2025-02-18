package kit.interview.ds_algo.dynamic_programming;

/*
Link: https://www.geeksforgeeks.org/find-maximum-possible-stolen-value-houses/
Company: Zeta
There are n houses build in a line, each of which contains some value in it. A thief is going to
steal the maximal value of these houses, but he can’t steal in two adjacent houses because the
owner of the stolen houses will tell his two neighbours left and right side. What is the maximum
stolen value?

Input: {6, 7, 1, 3, 8, 2, 4}
Output: 19 -> {6, 1, 8, 4}
*/
public class Q3MaxPossibleStolenValue {
    public static void main(String[] args) {
        int[] input = new int[] {6, 7, 1, 3, 8, 2, 4};
        int length = input.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int prev = i - 1;
            int prev2 = i - 2;

            result[i] = Math.max(input[i] + (prev2 >= 0 ? result[prev2] : 0),
                    prev >= 0 ? result[prev] : 0);
        }

        System.out.println(result[length - 1]);

    }
}
