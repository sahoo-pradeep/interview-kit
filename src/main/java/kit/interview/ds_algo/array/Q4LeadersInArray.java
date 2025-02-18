package kit.interview.ds_algo.array;

/*
Link: https://www.geeksforgeeks.org/leaders-in-an-array/
Leaders in an array: Write a program to print all the LEADERS in the array. An element is leader
if it is greater than all the elements to its right side. And the rightmost element is always a
leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
*/
public class Q4LeadersInArray {
    public static void main(String[] args) {
        int[] input = new int[]{16, 17, 4, 3, 5, 2};
        solve(input.length, input);
    }

    private static void solve(int size, int[] input){
        int max = Integer.MIN_VALUE;

        for (int i = size-1; i >= 0; i--){
            if (input[i] > max){
                System.out.print(input[i] + " ");
                max = input[i];
            }
        }
    }
}
