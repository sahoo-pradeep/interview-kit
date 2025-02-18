package kit.interview.ds_algo.tree;

public class Q1CreateBinaryTree {
    public static void main(String[] args) {
        BinaryTree bt = createBT();
        System.out.println(bt);

        BinaryTreeArray btArray = createBTArray();

        System.out.println(btArray);
    }

    private static BinaryTree createBT(){
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        bt.root.left = n2;
        bt.root.right = n3;
        n2.left = n4;

        return bt;
    }

    private static BinaryTreeArray createBTArray(){
        BinaryTreeArray bt = new BinaryTreeArray();
        int rootIndex = bt.setRoot(1);
        int index2 = bt.setLeft(2, rootIndex);
        int index3 = bt.setRight(3, rootIndex);
        int index4 = bt.setLeft(4, index2);
        int index5 = bt.setRight(5, index4);
        int index6 = bt.setLeft(6, index3);

        try {
            bt.setLeft(10, 6);
        }catch (Exception e){
            e.printStackTrace();
        }

        return bt;
    }
}
