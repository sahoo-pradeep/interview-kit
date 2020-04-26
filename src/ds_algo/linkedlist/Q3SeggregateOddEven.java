package ds_algo.linkedlist;

public class Q3SeggregateOddEven {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(11);
        list.add(6);
        list.add(8);
        list.add(7);
        list.add(4);
        list.add(3);
        list.add(1);
        list.add(5);
        System.out.println("Before: " + list);
        Node<Integer> result = solve(list.getHead());

        System.out.print("After: ");
        while (result != null){
            System.out.print(result.data + " -> ");
            result = result.next;
        }
    }

    private static Node<Integer> solve(Node<Integer> head) {
        Node<Integer> first = head;
        Node<Integer> lastInserted = null;

        Node<Integer> current = head;
        Node<Integer> previous = null;
        while (current != null){
            if (current.data % 2 == 1){
                // Delete
                if (previous == null){
                    // Fist node odd
                    lastInserted = current;
                    current = current.next;
                    head = head.next;
                    continue;
                }else {
                    previous.next = current.next;
                }

                // Add before head
                if (lastInserted == null){
                    first = current;
                    current.next = head;
                } else {
                    current.next = head;
                    lastInserted.next = current;
                }
                lastInserted = current;

                // Iterate
                current = previous.next;
            } else {
                previous = current;
                current = current.next;
            }
        }


        return first;
    }
}
