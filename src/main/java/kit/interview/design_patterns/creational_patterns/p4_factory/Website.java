package kit.interview.design_patterns.creational_patterns.p4_factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Website {
    protected List<Page> pages = new ArrayList<>();

    public Website(){
        System.out.println("Calling Website Constructor");
        createWebsite();
    }

    public abstract void createWebsite();

    public List<Page> getPages() {
        return pages;
    }
}
