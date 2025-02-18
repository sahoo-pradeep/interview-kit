package kit.interview.design_patterns.oops;

// Inherits the features (fields and methods) of other classes.
// Advantage: code reuse
// In Java, a class can extend a class or implements several Interfaces
public class P3Inheritance {
    public static void main(String[] args) {
        Dog jimmy = new Dog();
        jimmy.breathe();
        jimmy.walk();

        Crow kawwa = new Crow();
        kawwa.breathe();
        kawwa.fly();
        kawwa.walk();
    }

    static class Dog extends LivingOrganism implements Walkable {
        @Override
        public void walk() {
            System.out.println("Dog walking");
        }
    }


    static class Crow extends LivingOrganism implements Walkable, Flyable {
        @Override
        public void walk() {
            System.out.println("Crow Walking");
        }

        @Override
        public void fly() {
            System.out.println("Crow Flying");
        }
    }


    static class LivingOrganism {
        int eyes;
        int legs;

        void breathe() {
            System.out.println("Breathing");
        }
    }


    interface Walkable {
        void walk();
    }


    interface Flyable {
        void fly();
    }
}
