package design_patterns.creational_patterns.p2_builder;

public class LunchOrder {
    // Make all variables final to make it immutable
    private final String rice;
    private final String gravy;
    private final String drinks;
    private final String dessert;

    // Create a static class Builder (otherwise LunchOrder.Builder() will not be possible)
    // Parameter validity checks in constructor and methods - throw IllegalArgumentException

    public static class Builder {
        // Create the same fields

        // Required parameters
        private final String rice;
        private final String gravy;

        //Optional parameters - initialized to default values
        private String drinks = "";
        private String dessert = "";

        // We can add mandatory fields here
        public Builder(String rice, String gravy){
            //Add validity check for rice and gravy
            this.rice = rice;
            this.gravy = gravy;
        }

        public Builder drinks(String drinks){
            //Add validity check for drinks
            this.drinks = drinks;
            return this;
        }

        public Builder dessert(String dessert){
            //Add validity check for dessert
            this.dessert = dessert;
            return this;
        }

        // Create a build() method which creates parent object using its constructor.
        public LunchOrder build(){
            return new LunchOrder(this);
        }
    }

    // Create a constructor with takes Builder reference
    public LunchOrder(Builder builder){
        this.rice = builder.rice;
        this.gravy = builder.gravy;
        this.drinks = builder.drinks;
        this.dessert = builder.dessert;
    }

    //  getters
    public String getRice() {
        return rice;
    }

    public String getGravy() {
        return gravy;
    }

    public String getDrinks() {
        return drinks;
    }

    public String getDessert() {
        return dessert;
    }
}
