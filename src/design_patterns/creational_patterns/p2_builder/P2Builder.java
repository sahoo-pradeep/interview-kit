package design_patterns.creational_patterns.p2_builder;


/*
Concepts:
1. Handles complex constructor (with many arguments)
2. Force immutability
3. Handles telescoping constructor (Each constructor with one more field)

Design:
1. Static inner class.
2. Negates the need for setters.

Examples:
1. StringBuilder
2. Locale.Builder

Pitfalls:
1. Complexity

 */
public class P2Builder {

    public static final String BIRYANI = "Biryani";
    public static final String CHICKEN_MASALA = "Chicken Masala";
    public static final String COCACOLA = "Cocacola";
    public static final String GULAB_JAMUN = "Gulab Jamun";

    public static void main(String[] args) {
        /*
        Issues with lunch1:
        1. Can't specify mandatory items in lunch. Remove rice and  gravy, it will still run
        2. Not immutable
         */
        LunchOrderBean lunch1 = new LunchOrderBean();
        lunch1.setRice(BIRYANI);
        lunch1.setGravy(CHICKEN_MASALA);
        lunch1.setDrinks(COCACOLA);
        lunch1.setDessert(GULAB_JAMUN);

        /*
        Issue with telescoping constructor:
        1. Can't create a constructor which takes rice and drinks

        Advantage:
        1. Can create immutable object
         */
        LunchOrderTelescopic lunchOrder2 = new LunchOrderTelescopic(BIRYANI);
        lunchOrder2 = new LunchOrderTelescopic(BIRYANI, CHICKEN_MASALA);

        /*
        Using Builder
         */
        LunchOrder.Builder lunchBuilder = new LunchOrder.Builder();
        LunchOrder lunchOrder3 =
                lunchBuilder.rice(BIRYANI).drinks(COCACOLA).dessert(GULAB_JAMUN).build();

    }
}
