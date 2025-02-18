package kit.interview.design_patterns.creational_patterns.p2_builder;

public class LunchOrderTelescopic {
    private String rice;
    private String gravy;
    private String drinks;
    private String dessert;

    /*
    Telescoping Constructors
     */

    public LunchOrderTelescopic(String rice) {
        this.rice = rice;
    }

    public LunchOrderTelescopic(String rice, String gravy) {
        this(rice);
        this.gravy = gravy;
    }

    public LunchOrderTelescopic(String rice, String gravy, String drinks) {
        this(rice, gravy);
        this.drinks = drinks;
    }

    public LunchOrderTelescopic(String rice, String gravy, String drinks, String dessert) {
        this(rice, gravy, drinks); // calling constructor in recursive way
        this.dessert = dessert;
    }
}
