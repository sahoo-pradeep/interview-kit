package kit.interview.design_patterns.creational_patterns.p5_abstract_factory;

import design_patterns.creational_patterns.p5_abstract_factory.credit_card.CreditCard;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/*
Concepts:
1. Factory of Factories
2. Factory of related objects
3. Common Interface
4. Implementation defer to subclass

Example:
1. DocumentBuilderFactory

Design:
1. Groups factory together
2. Build using composition

Pitfalls:
1. Complexity
2. Pattern within pattern
3. Problem specific
 */
public class P5AbstractFactory {
    public static void main(String[] args) {
        CreditCardFactory abstractAmexFactory = CreditCardFactory.getCreditCardFactory(CreditCardBrand.AMEX);
        CreditCard amexCard = abstractAmexFactory.getCreditCard(CardType.PLATINUM);
        System.out.println(amexCard.getClass());

        CreditCardFactory abstractVisaFactory = CreditCardFactory.getCreditCardFactory(CreditCardBrand.VISA);
        CreditCard visaCard = abstractVisaFactory.getCreditCard(CardType.GOLD);
        System.out.println(visaCard.getClass());

        System.out.println(abstractAmexFactory.getValidator(CardType.PLATINUM).isValid(amexCard));
        System.out.println(abstractAmexFactory.getValidator(CardType.PLATINUM).isValid(visaCard));
    }

    private static void javaExample() {
        try {
            String xml =
                    "<document>"
                        + "<name>Pradeep</name>"
                        + "<age>25</age>"
                    + "</document>";

            InputStream inputStream = new ByteArrayInputStream(xml.getBytes());

            DocumentBuilderFactory abstractFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder factory = abstractFactory.newDocumentBuilder();
            Document doc = factory.parse(inputStream);

            System.out.println("Root: " + doc.getDocumentElement().getNodeName());

            System.out.println(abstractFactory.getClass().getName());
            System.out.println(factory.getClass().getName());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
