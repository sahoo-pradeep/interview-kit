package kit.interview.ds_algo.stack;

public class Q1StackBasicOperations {
    public static void main(String[] args) {
//        StackLinkedList stack = new StackLinkedList();
        StackArray stack = new StackArray(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(5);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(6);
    }
}
