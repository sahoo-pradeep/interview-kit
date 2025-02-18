package kit.interview.ds_algo.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class BinaryTreeArray {
    List<Integer> dataList = new ArrayList<>();

    public int setRoot(int data) {
        fillArray(1);
        dataList.set(0, data);
        return 0;
    }

    public int setLeft(int data, int index) {
        if (dataList.get(index) == null){
            throw new RuntimeException("Index is null: " + index);
        }

        int leftIndex = 2 * index + 1;
        fillArray(leftIndex + 1);

        dataList.set(leftIndex, data);
        return leftIndex;
    }

    public int setRight(int data, int index) {
        if (dataList.get(index) == null){
            throw new RuntimeException("Index is null: " + index);
        }
        int rightIndex = 2 * index + 2;
        fillArray(rightIndex + 1);

        dataList.set(rightIndex, data);
        return rightIndex;
    }


    private void fillArray(int size) {
        if (dataList.size() >= size) {
            return;
        }

        int extraData = size - dataList.size();

        while (extraData != 0) {
            dataList.add(null);
            extraData--;
        }
    }

    @Override
    public String toString() {
        final StringJoiner joiner = new StringJoiner(", ","[","]");
        for (int index = 0; index < dataList.size(); index++){
            joiner.add(dataList.get(index) + "(" + index + ")");
        }
        return joiner.toString();
    }
}
