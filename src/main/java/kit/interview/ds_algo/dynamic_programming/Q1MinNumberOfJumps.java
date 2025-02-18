package kit.interview.ds_algo.dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Link: https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
Link: https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0/?track=md-dp&batchId=144

Input:
3
11
1 3 5 8 9 2 6 7 6 8 9
6
1 4 3 2 6 7
10
2 3 1 1 2 4 2 0 1 1

Output:
3
2
4
*/
public class Q1MinNumberOfJumps {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int size = Integer.parseInt(br.readLine());
            String[] inputString = br.readLine().trim().split("\\s+");
            int[] input = new int[inputString.length];
            for (int j = 0; j < inputString.length; j++) {
                input[j] = Integer.parseInt(inputString[j]);
            }

            int result = solve(size, input);
            System.out.println(result);
        }
    }

    private static int solve(int size, int[] input) {
        if (input.length == 0){
            return -1;
        }

        int jumps = 0;
        int currentIndex = 0;
        int currentValue = input[currentIndex];

        while (true){
            if (currentValue == 0){
                return -1;
            }

            int nextIndex = -1;
            int netValue = -1;

            for (int i = 1; i <= currentValue; i++){
                int tempIndex = currentIndex + i;
                // Reached last element when tempIndex == input.length - 1
                if (tempIndex >= input.length - 1){
                    nextIndex = tempIndex;
                    break;
                }

                int tempNetValue = input[tempIndex] + i;

                if (tempNetValue > netValue){
                    nextIndex = tempIndex;
                    netValue = tempNetValue;
                }
            }
            jumps++;
            if (nextIndex >= input.length - 1){
                return jumps;
            } else {
                currentIndex = nextIndex;
                currentValue = input[currentIndex];
            }

        }
    }
}
