package kit.interview.ds_algo.array;

/*
Link: https://www.geeksforgeeks.org/counting-inversions/
Count Inversions in an array: Inversion Count for an array indicates – how far (or close) the
array is from being sorted. If array is already sorted then inversion count is 0. If array is
sorted in reverse order that inversion count is the maximum.
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
*/
public class Q5InversionCount {
    public static void main(String[] args) {
        int[] input = new int[] {8, 4, 2, 1};
        solve(input.length, input);
        //Output: 6. Explanation: (8,4), (4,2), (8,2), (8,1), (4,1), (2,1)
    }

    private static void solve(int size, int[] input) {
        //TODO
    }
}
