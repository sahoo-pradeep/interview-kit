package kit.interview.design_patterns.creational_patterns.p5_abstract_factory;

import design_patterns.creational_patterns.p5_abstract_factory.credit_card.CreditCard;
import design_patterns.creational_patterns.p5_abstract_factory.validator.Validator;

// Abstract Factory
public abstract class CreditCardFactory {
    public static CreditCardFactory getCreditCardFactory(CreditCardBrand brand){
        switch (brand){
            case VISA: return new VisaFactory();
            case AMEX: return new AmexFactory();
            default: return null;
        }
    }

    public abstract CreditCard getCreditCard(CardType cardType);

    public abstract Validator getValidator(CardType cardType);

}
