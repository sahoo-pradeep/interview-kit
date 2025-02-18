package kit.interview.java_problems.jvm.memory_management;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/*
Go to Run -> Edit Configuration. Try different VM Option and Run this program
eg: -XX:+UseConcMarkSweepGC
 */
public class MXBeanDemo {
    public static void main(String[] args) {
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : list){
            System.out.println("Name:" + bean.getName());
            System.out.println("Collection Count:" + bean.getCollectionCount());
            System.out.println("Collection Time:" + bean.getCollectionTime() + "ms");
            for(String poolName : bean.getMemoryPoolNames()){
                System.out.println("\t" + poolName);
            }
            System.out.println();
        }
    }
}
