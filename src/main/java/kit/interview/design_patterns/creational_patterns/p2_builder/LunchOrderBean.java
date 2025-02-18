package kit.interview.design_patterns.creational_patterns.p2_builder;

public class LunchOrderBean {
    private String rice;
    private String gravy;
    private String drinks;
    private String dessert;

    public LunchOrderBean() { }

    public String getRice() {
        return rice;
    }

    public void setRice(String rice) {
        this.rice = rice;
    }

    public String getGravy() {
        return gravy;
    }

    public void setGravy(String gravy) {
        this.gravy = gravy;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }
}
