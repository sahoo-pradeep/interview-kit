package kit.interview.ds_algo.tree;

public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return "Node: " + data;
    }
}
