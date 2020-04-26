package ds_algo.heap;

public class MinHeap {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    private int size = 0;
    private final int[] heap;

    public MinHeap(){
        this.heap = new int[DEFAULT_INITIAL_CAPACITY];
    }

    public MinHeap(int maxSize) {
        this.heap = new int[maxSize];
    }

    // Todo: Fix
    public MinHeap(int[] inputArray){
        size = inputArray.length;
        heap = inputArray;

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapifyUp(i);
        }
    }

    private int parent(int index) {
        // index is already root
        if (index == 0){
            return 0;
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    private boolean isLeaf(int index) {
        return index >= (size) / 2 && index < size;
    }

    private void swap(int first, int second) {
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    // If one of the children is smaller than parent, swap and heapify again (parent new index).
    private void heapifyDown(int index) {
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        int smallest = index;

        if (leftIndex < size && heap[leftIndex] < heap[smallest]){
            smallest = leftIndex;
        }

        if (rightIndex < size && heap[rightIndex] < heap[smallest]){
            smallest = rightIndex;
        }

        if (smallest != index){
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // If element is smaller than its parent, swap with parent, and heapifyUp element (new index)
    private void heapifyUp(int index){
        if (heap[index] < heap[parent(index)]){
            swap(index, parent(index));
            heapifyUp(parent(index));
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == heap.length;
    }

    public void add(int value) {
        if (isFull()) {
            throw new RuntimeException("Heap is full");
        }

        heap[size++] = value;
        heapifyUp(size - 1);
    }

    public int remove() {
        if (isEmpty()){
            throw new RuntimeException("Heap is Empty");
        }

        int root = heap[0];

        swap(0, --size);
        heapifyDown(0);

        return root;
    }

    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("Heap is Empty");
        }
        return heap[0];
    }

    public void clear(){
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("MinHeap:\n");
        for (int i = 0; i < size; i++){
            stringBuilder.append(heap[i] + " ");
        }

        return stringBuilder.toString();
    }
}
