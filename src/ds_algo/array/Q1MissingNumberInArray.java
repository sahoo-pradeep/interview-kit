package ds_algo.array;

/*
Link: https://www.geeksforgeeks.org/find-the-missing-number/

Q: Given an array C of size N-1 and given that there are numbers from 1 to N with one element
missing, the missing number is to be found.
*/
public class Q1MissingNumberInArray {
    public static void main(String[] args) {
        int size = 5;
        int[] input = new int[] {1, 2, 3, 5};
        int result = solve(size, input);
        System.out.println("Result: " + result);

        int size2 = 10;
        int[] input2 = new int[] {5, 1, 4, 6, 3, 2, 9, 10, 8};
        int result2 = solve(size2, input2);
        System.out.println("Result2: " + result2);
    }

    private static int solve(int size, int[] input) {
        int result = 1;
        for (int i = 2; i <= size; i++) {
            result = result ^ i;
        }

        for (int value : input) {
            result = result ^ value;
        }

        return result;
    }
}
