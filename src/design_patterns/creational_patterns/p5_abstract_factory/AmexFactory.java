package design_patterns.creational_patterns.p5_abstract_factory;

import creational_patterns.p5_abstract_factory.credit_card.AmexGoldCreditCard;
import creational_patterns.p5_abstract_factory.credit_card.AmexPlatinumCreditCard;
import creational_patterns.p5_abstract_factory.credit_card.CreditCard;
import creational_patterns.p5_abstract_factory.validator.AmexGoldValidator;
import creational_patterns.p5_abstract_factory.validator.AmexPlatinumValidator;
import creational_patterns.p5_abstract_factory.validator.Validator;

//Factory 1 : AmexFactory
public class AmexFactory extends CreditCardFactory {
    @Override
    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType) {
            case GOLD:
                return new AmexGoldCreditCard();
            case PLATINUM:
                return new AmexPlatinumCreditCard();
            default:
                return null;
        }
    }

    @Override
    public Validator getValidator(CardType cardType) {
        switch (cardType) {
            case GOLD:
                return new AmexGoldValidator();
            case PLATINUM:
                return new AmexPlatinumValidator();
            default:
                return null;
        }
    }
}
