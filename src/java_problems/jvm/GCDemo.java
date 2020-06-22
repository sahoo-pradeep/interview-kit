package java_problems.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/*
java -cp out\production\interview-kit java_problems.jvm.GCDemo > address.csv

Output: SeaSaw shape address -> assign address -> GC -> lower address
 */
public class GCDemo {
    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        for (int i = 0; i < 500_000; i++){
            GCMe obj = new GCMe();
            printAddresses(obj);
        }
    }

    private static void printAddresses(Object obj) {
        Object[] array = new Object[]{obj};

        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize(); // 4 = 32bit, 8 = 64bit

        switch (addressSize){
            case 4 :
                System.out.println(unsafe.getInt(array, baseOffset)); break;
            case 8: System.out.println(unsafe.getLong(array, baseOffset)); break;
            default:
                System.err.println("Unsupported Address Size");
        }
    }
}