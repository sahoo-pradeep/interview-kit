package kit.interview.ds_algo.heap;

public class Q1MinHeap {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(20);
        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(17);
        minHeap.add(10);
        minHeap.add(84);
        minHeap.add(19);
        minHeap.add(6);
        minHeap.add(22);
        minHeap.add(9);
        System.out.println(minHeap);

        MinHeap minHeap1 = new MinHeap(new int[]{5, 3, 17, 10, 84, 19, 6, 22, 8});
        System.out.println(minHeap1);
    }
}
