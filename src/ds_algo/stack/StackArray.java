package ds_algo.stack;

import java.util.StringJoiner;

public class StackArray {
    private int[] data;
    private int head;

    public StackArray(int size) {
        data = new int[size];
    }

    public boolean push(int value){
        if (isFull()){
            System.out.println("Stack is Empty. Push unsuccessful: " + value);
            return false;
        }

        data[head] = value;
        head++;
        System.out.println("Pushed successfully: " + value + ", data: " + prettyPrint());
        return true;
    }

    public boolean pop(){
        if (isEmpty()){
            System.out.println("Stack is Empty. Push unsuccessful.");
            return false;
        }

        head--;
        int value = data[head];
        System.out.println("Popped successfully: " + value + ", data: " + prettyPrint());
        return true;
    }


    private boolean isFull(){
        return head == data.length;
    }

    private boolean isEmpty(){
        return head == 0;
    }

    public String prettyPrint(){
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        for (int i = 0; i < head; i++){
            joiner.add(String.valueOf(data[i]));
        }
        return joiner.toString();
    }
}
