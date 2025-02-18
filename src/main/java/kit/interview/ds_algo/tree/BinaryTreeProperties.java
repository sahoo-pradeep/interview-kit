package kit.interview.ds_algo.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeProperties {
    List<String> properties = new ArrayList<>();
    Map<String, String> typesOfBinaryTree = new HashMap<>();


    {
        properties.add("Max no of nodes in Level L is 2^(L-1). Root has L = 1");
        properties.add("Max no of nodes in BT of height h is 2^h - 1. Tree with only root has h = 1");
        properties.add("Min height of Tree with N nodes is Log2(N + 1) "); //Log2 = Log base2
        properties.add("In BT where every node have 0 or 2 children, No of Leaf Nodes = No of Nodes with 2 Children + 1");

        typesOfBinaryTree.put("Full Binary Tree", "Every node has 0 or 2 children"); // Property 4
        typesOfBinaryTree.put("Complete Binary Tree",
                "All levels are completely filled except last level. Last level has all nodes as left as possible");
        typesOfBinaryTree.put("Perfect Binary Tree", "Full Binary Tree with all leaf nodes at same level");
        typesOfBinaryTree.put("Balanced Tree", "Height of tree is O(Log n). AVL, RedBlackTree");

    }

}
