package ds_algo.sorting;

import java.util.StringJoiner;

public class S1MergeSort {
    public static void main(String[] args) {
        int[] input = new int[] {8, 4, 2, 1};
        print(input);
        sort(input, 0, input.length - 1);
        print(input);

    }

    private static void sort(int[] input, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        sort(input, start, mid);
        sort(input, mid + 1, end);
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {
        // Size of left and right array
        int l = mid - start + 1;
        int r = end - mid;

        int[] leftArray = new int[l];
        int[] rightArray = new int[r];

        // Fill arrays
        System.arraycopy(input, start, leftArray, 0, l);
        System.arraycopy(input, mid + 1, rightArray, 0, r);

        for (int i = 0; i < r; i++) {
            rightArray[i] = input[i + mid + 1];
        }

        int i = 0;
        int j = 0;
        while (i < l && j < r) {
            if (leftArray[i] <= rightArray[j]) {
                input[start++] = leftArray[i++];
            } else {
                input[start++] = rightArray[j++];
            }
        }

        while (i < l) {
            input[start++] = leftArray[i++];
        }

        while (j < r) {
            input[start++] = rightArray[j++];
        }
    }

    private static void print(int[] input) {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (int i : input) {
            stringJoiner.add(Integer.toString(i));
        }
        System.out.println(stringJoiner);
    }
}
