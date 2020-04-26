package design_patterns.creational_patterns.p5_abstract_factory;

import creational_patterns.p5_abstract_factory.credit_card.CreditCard;
import creational_patterns.p5_abstract_factory.credit_card.VisaGoldCreditCard;
import creational_patterns.p5_abstract_factory.credit_card.VisaPlatinumCreditCard;
import creational_patterns.p5_abstract_factory.validator.Validator;
import creational_patterns.p5_abstract_factory.validator.VisaGoldValidator;
import creational_patterns.p5_abstract_factory.validator.VisaPlatinumValidator;

// Factory 2: Visa Factory
public class VisaFactory extends CreditCardFactory {
    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType) {
            case GOLD:
                return new VisaGoldCreditCard();
            case PLATINUM:
                return new VisaPlatinumCreditCard();
            default:
                return null;
        }
    }

    @Override
    public Validator getValidator(CardType cardType) {
        switch (cardType) {
            case GOLD:
                return new VisaGoldValidator();
            case PLATINUM:
                return new VisaPlatinumValidator();
            default:
                return null;
        }
    }
}
