package java_problems.basic_interview;

public class PolymorphismDemo {
    public static class Animal {
        public static void print(){ System.out.println("Animal"); }
        public void canDo(){ System.out.println("Anything"); }
    }

    public static class Dog extends Animal {
        public static void print(){ System.out.println("Dog"); }
        public void canDo(){ System.out.println("Bark"); }
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        Animal b = new Dog();
        Dog c = new Dog();

        a.print();
        b.print();
        c.print();

        a.canDo();
        b.canDo();
        c.canDo();
    }
}