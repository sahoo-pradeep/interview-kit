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
public class Q4HeightOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);

        int height = solve(root);
        System.out.println("Height: " + height);
    }

    private static int solve(Node root){
        if (root == null){
            return 0;
        }

        int l = solve(root.left);
        int r = solve(root.right);

        if (l > r){
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
