package kit.interview.design_patterns.oops;

import java.util.ArrayList;
import java.util.List;

// Polymorphism is the ability to execute the correct method.
//
// In Java, we can achieve this by
// 1. overloading (method with same name but different parameters - compile time - static binding)
// 2. overriding (calling method of super class. Execution of methods in runtime - dynamic binding)
public class P4Polymorphism {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal());
        animals.add(new Dog());
        animals.add(new Cat());

        for (Animal a : animals){
            a.makeSound();
        }
    }

    static class Animal {
        public void makeSound() {
            System.out.println("Animal sound");
        }
    }


    static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Bark");
        }
    }


    static class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Meow");
        }
    }
}
