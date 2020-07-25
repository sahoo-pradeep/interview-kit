package java_problems.jvm.class_loading;

import java.net.URL;
import java.net.URLClassLoader;

public class CLassLoadingDelegation {
    public static void main(String[] args) {
        URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        while (classLoader != null){
            // Name of classLoader
            System.out.println(classLoader);

            for (URL url : classLoader.getURLs()){
                // classpath
                System.out.printf("\t %s%n", url.getPath());
            }

            classLoader = (URLClassLoader) classLoader.getParent();
        }

        System.out.println("Bootstrap class loader");
    }
}
