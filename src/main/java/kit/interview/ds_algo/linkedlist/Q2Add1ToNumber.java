package kit.interview.ds_algo.linkedlist;

/*
Link: https://www.geeksforgeeks.org/add-1-number-represented-linked-list/
Company: Zeta
Given LinkedList: 1 -> 9 -> 9 -> 9
Output: 2 -> 0 -> 0 -> 0
*/
public class Q2Add1ToNumber {
    public static void main(String[] args) {
        Node<Integer> headNode = new Node<>(1);
        Node<Integer> node1 = new Node<>(9);
        Node<Integer> node2 = new Node<>(9);
        Node<Integer> node3 = new Node<>(9);

        headNode.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.print("Input: ");
        print(headNode);

        // Solve
        headNode = reverse(headNode);

        System.out.print("Reversed: ");
        print(headNode);

        // Add 1 to number
        int carry = 1;
        Node<Integer> current = headNode;
        while (current != null){
            int total = current.data + carry;
            if (total > 9){
                current.data = total - 10;
            } else {
                current.data = total;
                break;
            }
            current = current.next;
        }

        headNode = reverse(headNode);

        System.out.print("Result: ");
        print(headNode);

    }

    public static void print(Node<Integer> node){
        if (node == null){
            return;
        }

        System.out.print(node.data);

        while (node.next != null){
            node = node.next;
            System.out.print(node.data);
        }
        System.out.println();
    }

    public static Node<Integer> reverse(Node<Integer> headNode){
        Node<Integer> prev = null;
        Node<Integer> current = headNode;

        while (current != null){
            Node<Integer> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
