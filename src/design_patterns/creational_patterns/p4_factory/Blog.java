package design_patterns.creational_patterns.p4_factory;

// Concrete class creating the implementation
public class Blog extends Website {

    public Blog() {
        System.out.println("Calling Blog Constructor");
    }

    @Override
    public void createWebsite() {
        System.out.println("Calling Blog.createWebsite()");
        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new ContactPage());
    }
}
