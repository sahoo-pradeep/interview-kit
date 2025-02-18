package kit.interview.design_patterns.solid_principles;

/*
Dependency Inversion Principle: High-level classes shouldn't depend on low-level classes. Both
should depend on abstractions. Abstractions shouldn't depend on details. Details should depend on
abstractions.
Low-level classes: implement basic operations such as transfer data to network, connection to db
High-level classes: Complex business logic that directs low-level classes to do something.

Usually, people design low-level design first and then only start working on high-level ones.
With this approach, business logic tend to become dependent on low-level classes.

This principle suggests:
1. Define interfaces for low level operations that high level classes rely on.
2. Now, you can make high-level class dependent on those interfaces, instead of concrete
low-level classes.
3. Once low-level classes implement these interfaces, they become dependent on business logic
level. Reversing the direction of original dependency.

Eg. In Spring JPA, we can change the database without effecting the business logic.
*/
public class P5DependencyInversion {}
