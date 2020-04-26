package design_patterns.creational_patterns.p5_abstract_factory.validator;

import design_patterns.creational_patterns.p5_abstract_factory.credit_card.CreditCard;

public class VisaGoldValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return true;
    }
}
