package design_patterns.creational_patterns.p4_factory;

public class WebsiteFactory {
    public enum WebsiteType {
        BLOG,
        E_COMMERCE
    }

    public static Website getWebsite(WebsiteType websiteType){
        switch (websiteType) {
            case BLOG: return new Blog();
            case E_COMMERCE: return new ECommerce();
            default: return null;
        }
    }
}
