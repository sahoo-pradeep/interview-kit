package design_patterns.creational_patterns.p4_factory;

public class ECommerce extends Website {

    public ECommerce() {
        System.out.println("Calling E-Commerce Constructor");
    }

    @Override
    public void createWebsite() {
        System.out.println("Calling ECommerce.createWebsite()");
        pages.add(new CartPage());
        pages.add(new SearchPage());
        pages.add(new ItemPage());
    }
}
