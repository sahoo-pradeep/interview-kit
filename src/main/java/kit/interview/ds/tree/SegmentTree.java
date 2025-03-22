package kit.interview.ds.tree;

import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * ref: <a href="https://www.youtube.com/watch?v=ciHThtTVNto&t=2333s&ab_channel=KunalKushwaha">Segment Trees Tutorial</a>
 */
public class SegmentTree {
    private static final Logger logger = LoggerFactory.getLogger(SegmentTree.class);
    final private Node root;

    public static void main(String[] args) {
        // given
        int[] input = new int[]{3, 4, 2, 1};
        // when
        SegmentTree tree = new SegmentTree(input);
        // then

        Assertions.assertEquals(7, tree.sum(0, 1));
        tree.update(0, 2);
        Assertions.assertEquals(6, tree.sum(0, 1));
    }

    /**
     * Creates a segment tree using int array.
     */
    public SegmentTree(int[] input) {
        logger.info("Initializing Segment Tree. start={} end={} input={}", 0, input.length - 1, Arrays.toString(input));
        root = init(0, input.length - 1, input);
    }

    private Node init(int start, int end, int[] input) {
        Node node = new Node(start, end);
        if (node.isLeaf()) {
            node.value = input[start];
            return node;
        }

        int mid = (start + end) / 2;
        node.left = init(start, mid, input);
        node.right = init(mid + 1, end, input);
        node.value = node.left.value + node.right.value;
        return node;
    }

    /**
     * Updates value at index at O(logN)
     */
    public void update(int index, int value) {
        System.out.println("Updating index " + index + " with value " + value);
        update(index, value, root);
    }

    private void update(int index, int value, Node node) {
        if (index >= node.start && index <= node.end) {
            if (node.isLeaf()) {
                node.value = value;
            } else {
                update(index, value, node.left);
                update(index, value, node.right);
                node.value = node.left.value + node.right.value;
            }
        }
    }

    /**
     * Sum of elements from start index to end index(both inclusive) at O(logN).
     */
    public int sum(int start, int end) {
        return sum(start, end, root);
    }

    private int sum(int start, int end, Node node) {
        if (node.start == start && node.end == end) {
            return node.value;
        }

        if (node.end < start || node.start > end) {
            return 0;
        }

        return sum(start, end, node.left) + sum(start, end, node.right);
    }

    static class Node {
        int value;
        int start;
        int end;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        boolean isLeaf() {
            return start == end;
        }
    }
}
