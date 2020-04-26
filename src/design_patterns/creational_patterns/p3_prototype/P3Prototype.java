package design_patterns.creational_patterns.p3_prototype;

/*
Concepts:
1. Guarantee unique instance
2. Avoid costly creation
3. Avoids subclassing
4. Typically, doesn't use 'new'. Objects are cloned after creating first instance
5. Utilizes an Interface
6. Implemented with Registry

Example:
1. java.lang.Object.clone()

Design:
1. implements cloneable (avoids new)
2. Construction not handled by client (unlike Builder)
3. Shallow OR Deep Copy

Pitfalls:
1. Not clear when to use
2. Shallow vs Deep Copy
 */
public class P3Prototype {
    public static void main(String[] args) {
        Registry registry = new Registry();
        Movie kgf = (Movie)(registry.createItem(Registry.ProductType.MOVIE));
        kgf.setTitle("KGF");
        kgf.setRuntime("2hr 45min");
        System.out.println(kgf);
        System.out.println(kgf.getTitle());
        System.out.println(kgf.getRuntime());
        System.out.println();
        Movie gof = (Movie)(registry.createItem(Registry.ProductType.MOVIE));
        gof.setTitle("Gangs of Four");
        System.out.println(gof);
        System.out.println(gof.getTitle());
        System.out.println(gof.getRuntime());
    }
}
