package design_patterns.design_principles;
/*
Favor Composition Over Inheritance: In inheritance, we need to create a lot of class combinations in
two or more dimensions.
Eg: A car manufacturer makes both Car and Truck; they can be either Electric or Gas; all models
have either manual or auto gears. (3 dimension: Car type * engine type * gear type).

Transport   -> Car      -> Electric Car     -> Manual Electric Car
                                            -> Auto Electric Car
                        -> Combustion Car   -> Manual Combustion Car
                                            -> Auto Combustion Car
            -> Truck    -> Electric Truck   -> Manual Electric Truck
                                            -> Auto Electric Truck
                        -> Combustion Truck -> Manual Combustion Truck
                                            -> Auto Combustion Truck
Solution: Instead of car object implementing a behaviour, they can delegate to other object.

Car {
    Engine engine;
}

Engine {
    Gear gear;
}

Inheritance: 'is a' relationship
Composition: 'has a' relationship
*/
public class P3FavourCompositionOverInterface {}
