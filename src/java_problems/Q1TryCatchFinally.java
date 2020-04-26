package java_problems;

public class Q1TryCatchFinally {
    public static void main(String[] args) {
        System.out.println(problem1());
    }

    private static int problem1() {
        try {
            System.out.println("Problem1: Inside try");
            int num = 2 / 0;
            return 1;
        } catch (Exception e) {
            System.out.println("Problem1: Inside catch");
            return 2;
        } finally {
            System.out.println("Problem1: Inside finally");
            return 3;
        }
    }
}
