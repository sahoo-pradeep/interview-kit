package kit.interview.design_patterns.creational_patterns.p3_prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    public enum ProductType {
        MOVIE,
        BOOK
    }

    private Map<ProductType, Product> products = new HashMap<>();

    public Registry(){
        loadProducts();
    }

    public Product createItem(ProductType productType){
        Product product = null;


        try {
            product = (Product)(products.get(productType)).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return product;
    }

    private void loadProducts(){
        Movie batman = new Movie();
        batman.setTitle("Batman");
        batman.setPrice(200.0);
        batman.setRuntime("2hr");

        products.put(ProductType.MOVIE, batman);

        Book java = new Book();
        java.setTitle("Java");
        java.setPrice(875.0);
        java.setPages(1023);

        products.put(ProductType.BOOK, java);
    }
}
