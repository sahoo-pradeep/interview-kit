package java_problems.jvm.memory_management;

import java.util.Random;

/*
Go to CMD and type jvisualvm
Install Plugin 'Visual GC'
 */
public class JVisualVMDemo {
    public static void main(String[] args) throws InterruptedException {
        int arraySize = 1_000_000;
        GCMe[] gcArray = new GCMe[arraySize]; //Empty Array
        int count = 1;
        Random random = new Random();
        while (true) {
            int index = random.nextInt(arraySize);
            //Filling the array. Overwriting the values. Old values getting collected by GC
            gcArray[index] = new GCMe();
            // To see object allocation speed
            if (count % 1_000_000 == 0) {
                System.out.print("*");
                count = 1;
            }
            // To slow down allocation, so that we can see how memory is getting filled
            if (index % 50 == 0) {
                Thread.sleep(1);
            }
            count++;
        }
    }
}
