package Base;
import interfaces.Expression;

public abstract class BaseExpression implements Expression {
    public abstract String baseString();

    @Override
    public String toString() {
        return String.format("%s", baseString());
    }

    @Override
    public boolean equals(Expression expression) {
        return baseString().compareTo(expression.toString()) == 0;
    }
    @Override
    public boolean isNeg(){
        return false;
    }
    @Override
    public Expression getExpression(){
        return null;
    }

}
