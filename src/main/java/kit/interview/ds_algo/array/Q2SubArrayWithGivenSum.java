package kit.interview.ds_algo.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
Link: https://www.geeksforgeeks.org/find-subarray-with-given-sum/
Q: Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a
given number. (first such occurring sub-array from the left)
Return: start and end index if found otherwise return -1
1
5 12
1 3 3 7 5

*/
public class Q2SubArrayWithGivenSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            String[] inputStr1 = br.readLine().trim().split("\\s+");
            String[] inputStr2 = br.readLine().trim().split("\\s+");

            int size = Integer.parseInt(inputStr1[0]);
            int sum = Integer.parseInt(inputStr1[1]);

            int[] input = new int[size];

            for (int j = 0; j < size; j++) {
                input[j] = Integer.parseInt(inputStr2[j]);
            }

            solve(sum, size, input);
        }
    }

    private static void solve(int sum, int size, int[] input) {
        int left = 0;
        int right = 0;

        int currentSum = input[0];

        while (left < size && right < size) {
            if (currentSum == sum) {
                System.out.println("[" + left + ", " + right + "]");
                return;
            }else if (currentSum < sum) {
                currentSum += input[++right];
            } else {
                currentSum -= input[left++];
            }
        }

        System.out.println("-1");
    }
}
