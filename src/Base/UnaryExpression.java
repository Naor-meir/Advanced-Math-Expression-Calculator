package Base;

import interfaces.Expression;

import java.util.List;

public abstract class UnaryExpression implements Expression {
    private Expression expression;



    public UnaryExpression(Expression expression) {
        this.expression = expression;
    }

    public List<String> getVariables() {
        if (this.expression.getVariables() == null) {
            return null;
        }
        return this.expression.getVariables();
    }

    public abstract Expression create(Expression expression);

    public Expression assign(String var, Expression expression) {
        return create(expression.assign(var, expression));
    }

    @Override
    public boolean equals(Expression expression) {
        return this.toString().compareTo(expression.toString()) == 0;
    }

    public void firstAndSecond(Expression expression1) {
        this.expression = expression1;

    }


}
