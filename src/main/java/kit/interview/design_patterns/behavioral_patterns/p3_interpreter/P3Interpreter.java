package kit.interview.design_patterns.behavioral_patterns.p3_interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Concepts:
1. Represent Grammar
2. Interpret a sentence
3. Good to implement Rules or Validation
4.

Examples:
1. java.util.Pattern
2. java.util.Format

Design:
1. Abstract Expression
2. Interpret
3. Terminal and Non Terminal Expression

Pitfalls:
1. Complexity
2. Class per Rule
 */
public class P3Interpreter {
    public static void main(String[] args) {
        Expression lionTerminal = new TerminalExpression("Lion");
        Expression tigerTerminal = new TerminalExpression("Tiger");
        Expression lionOrTiger = new OrExpression(lionTerminal, tigerTerminal);
        Expression lionAndTiger = new AndExpression(lionTerminal, tigerTerminal);

        int count = 1;
        System.out.println("Result "+ count++ + " : " + lionTerminal.interpret("I like Lion"));
        System.out.println("Result "+ count++ + " : " + lionTerminal.interpret("I like Tiger"));
        System.out.println("Result "+ count++ + " : " + lionOrTiger.interpret("I like Lion"));
        System.out.println("Result "+ count++ + " : " + lionOrTiger.interpret("I like Tiger"));
        System.out.println("Result "+ count++ + " : " + lionAndTiger.interpret("I like Tiger"));
        System.out.println("Result "+ count++ + " : " + lionAndTiger.interpret("I like Tiger and Lion as well"));
    }

    private static void javaExample(){
        String input = "Lions, and tigers, and bears! Oh, my!";

        Pattern pattern = Pattern.compile("(lion|cat|dog|wolf|bear|human|tiger)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            System.out.println("Found a " + matcher.group() + ".");
        }
    }
}
