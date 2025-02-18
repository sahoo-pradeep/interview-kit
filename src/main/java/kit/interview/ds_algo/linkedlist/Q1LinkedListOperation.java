package kit.interview.ds_algo.linkedlist;

public class Q1LinkedListOperation {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.add(2);
        linkedList.add(4);
        linkedList.add(8);
        linkedList.add(10);
        System.out.println("Values Added. LinkedList: " + linkedList + " size: " + linkedList.size());
        linkedList.remove(8);
        System.out.println("8 Removed. LinkedList: " + linkedList + " size: " + linkedList.size());

        linkedList.reverse();
        System.out.println("Reversed. LinkedList: " + linkedList + " size: " + linkedList.size());

        linkedList.remove(10);
        System.out.println("10 Removed. LinkedList: " + linkedList + " size: " + linkedList.size());
        linkedList.remove(2);
        System.out.println("2 Removed. LinkedList: " + linkedList + " size: " + linkedList.size());
        linkedList.remove(4);
        System.out.println("4 Removed. LinkedList: " + linkedList + " size: " + linkedList.size());
        linkedList.add(50);
        System.out.println("50 Added. LinkedList: " + linkedList + " size: " + linkedList.size());
    }
}
