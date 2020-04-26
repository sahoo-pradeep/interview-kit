package ds_algo.tree;

/*
Tree:
        1
      /   \
    2       3
  /
4
  \
    5

*/
public class Q5CountLeavesInBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);

        int leaves = countLeaves(root);
        System.out.println("Leaves: " + leaves);
    }

    private static int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }

        boolean bothNull = true;
        int l = 0;
        int r = 0;


        if (node.left != null) {
            bothNull = false;
            l = countLeaves(node.left);
        }

        if (node.right != null) {
            bothNull = false;
            r = countLeaves(node.right);
        }

        if (bothNull) {
            return 1;
        } else {
            return l + r;
        }
    }
}
