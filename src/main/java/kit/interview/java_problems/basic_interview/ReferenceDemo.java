package kit.interview.java_problems.basic_interview;

public class ReferenceDemo {
    public static void main(String[] args) {
        ReferenceDemo client = new ReferenceDemo();
        Integer i = 3;
        Integer[] arr = new Integer[]{3};
        client.addOne(i, arr);
        System.out.println(i);
        System.out.println(arr[0]);
    }

    public void addOne(Integer j, Integer[] arr) {
        j = j + 1;
        arr[0] = arr[0] + 1;
    }
}
