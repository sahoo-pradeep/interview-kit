package design_patterns.behavioral_patterns.p3_interpreter;

// Non Terminating Expression
public class OrExpression implements Expression {
    private Expression first;
    private Expression second;

    public OrExpression(Expression first, Expression second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean interpret(String str) {
        return first.interpret(str) || second.interpret(str);
    }
}
