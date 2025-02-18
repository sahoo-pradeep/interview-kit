package kit.interview.java_problems.jvm.memory_management;

import java.util.Random;

/*
Open CMD.
1. Find PID: type jps and get PID of this application (6372 JStatDemo)
2. %tage of memory space: jstat -gcutil 6372
3. GC Cause: jstat -gccause 6372
4. Memory Allocation: jstat -gccapacity 6372
5. Space for each Space: jstat -gc 6372
6. Stats with intervals: jstat -gc 6372 1000 10 (10 records with 1sec interval)

Note: Try changing the GC, and see the different result

S0, S1 - Survivor Space
E - Eden Space
O - Old Space
M - Metaspace
YGC - Young GC count
YGCT - Average time of Young GC
FGC - Full GC Count
FGCT - Average time of Full GC
LGCC - Last GC Cause
GCC - Current GC Cause
 */
public class JStatDemo {
    public static void main(String[] args) throws InterruptedException {
        int arraySize = 1_000_000;
        GCMe[] gcArray = new GCMe[arraySize]; //Empty Array
        int count = 0;
        Random random = new Random();
        while (true){
            int index = random.nextInt(arraySize);
            //Filling the array. Overwriting the values. Old values getting collected by GC
            gcArray[index] = new GCMe();
            if (count % 10_000_000 == 0){
                System.out.print("*");
                count = 0;
            }
            count++;
        }
    }
}
