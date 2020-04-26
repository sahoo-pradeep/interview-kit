package design_patterns.solid_principles;

/*
Liskov Substitution Principle: When extending a class, remember that you should be able to pass
objects of the subclass in place of objects of the parent class without breaking the client code.
Subclass should remain compatible with superclass. When overriding a method, extend the base
behaviour instead of writing a completely different logic.

Subclass checklist:
1. Parameter types in a method of subclass should match or be more abstract than Parameter types
in superclass method. (Java throws Compile time exception if violates)
class Animal {
    feed(Rice rice);
}

class Dog extends Animal {
    feed(Food food); // Rice extends Food. Food is more abstract than Rice
}

2. The return type in a method of a subclass should match or be a subtype of the return type in
the method of the superclass. (Java throws Compile time exception if violates)

3. A method in a subclass shouldn't throw types of exceptions which the base method isn't
expected to throw. (Java throws Compile time exception if violates)

4. A subclass shouldn't strengthen pre-conditions.
Eg: In superclass, method(int i) -> accepts all values of i.
But in subclass, method(int i) -> throws error if i <= 0. This is called strengthening pre-conditions.

5. A subclass shouldn't weaken post-conditions.
Eg: In superclass, method close all db connections.
In subclass, method do not close db connections. -> this is called weakening post-conditions.

6. Invariants of a superclass must be preserved.
Invariants are variables which should have have some specific values only.
Eg. Cat class should have int legs = 4

7. A subclass shouldn't change values of private fields of the superclass
Subclass can change the superclass private values using Reflection
*/
public class P3LiskovSubstitution {
    public static void main(String[] args) {

    }

    private static class Animal {
        Rice getEatable() {
            return new Rice();
        }
    }


    private static class Human extends Animal {
        @Override
        Biryani getEatable() {
            return new Biryani();
        }
    }


    private static class Food {}
    private static class Rice extends Food {}
    private static class Biryani extends Rice {}
}
