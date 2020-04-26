package design_patterns.creational_patterns.p5_abstract_factory.validator;

import design_patterns.creational_patterns.p5_abstract_factory.credit_card.AmexPlatinumCreditCard;
import design_patterns.creational_patterns.p5_abstract_factory.credit_card.CreditCard;

public class AmexPlatinumValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        if (creditCard instanceof AmexPlatinumCreditCard){
            return true;
        } else {
            return false;
        }
    }
}
