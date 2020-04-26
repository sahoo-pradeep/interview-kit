package design_patterns.creational_patterns.p4_factory;

/*
Concepts:
1. Doesn't expose instantiation logic
2. Common Interface exposed
3. Defer to subclass for object creation

Examples:
1. Calender
2. ResourceBundle
3. NumberFormat

Design:
1. Objects referenced through common interface
2. Factory refer Concrete Classes or multiple implementation, but client is unaware.
3. Parameterized create method

Pitfalls:
1. Complexity
2. Creation in subclass
3. Plan before designing. Can't refactor in middle
 */
public class P4Factory {
    public static void main(String[] args) {
        Website flipkart = WebsiteFactory.getWebsite(WebsiteFactory.WebsiteType.E_COMMERCE);
        System.out.println(flipkart.getPages());

        System.out.println();

        Website myJourney = WebsiteFactory.getWebsite(WebsiteFactory.WebsiteType.BLOG);
        System.out.println(myJourney.getPages());
    }
}
