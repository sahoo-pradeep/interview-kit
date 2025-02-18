package kit.interview.java_problems.basic_interview;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Animal someAnimal = new Animal();
        Animal anotherAnimal = new Dog();
        Dog myDog = new Dog();

        someAnimal.print();
        anotherAnimal.print();
        myDog.print();

        someAnimal.canDo();
        anotherAnimal.canDo();
        myDog.canDo();
    }

    public static class Animal {
        public static void print(){ System.out.println("Animal"); }
        public void canDo(){ System.out.println("Anything"); }
    }

    public static class Dog extends Animal {
        public static void print(){ System.out.println("Dog"); }
        public void canDo(){ System.out.println("Bark"); }
    }

}