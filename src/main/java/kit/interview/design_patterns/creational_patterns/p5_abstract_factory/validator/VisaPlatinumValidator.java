package kit.interview.design_patterns.creational_patterns.p5_abstract_factory.validator;

import kit.interview.design_patterns.creational_patterns.p5_abstract_factory.credit_card.CreditCard;

public class VisaPlatinumValidator implements Validator {
    @Override
    public boolean isValid(CreditCard creditCard) {
        return true;
    }
}
