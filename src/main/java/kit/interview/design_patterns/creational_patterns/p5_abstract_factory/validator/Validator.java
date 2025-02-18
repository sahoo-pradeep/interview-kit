package kit.interview.design_patterns.creational_patterns.p5_abstract_factory.validator;

import kit.interview.design_patterns.creational_patterns.p5_abstract_factory.credit_card.CreditCard;

public interface Validator {
    boolean isValid(CreditCard creditCard);
}
