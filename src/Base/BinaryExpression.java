package Base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import elements.Num;
import interfaces.Expression;

public abstract class BinaryExpression implements Expression {
    protected Expression expressionFirst, expressionSecond;

    public BinaryExpression(Expression expressionFirst, Expression expressionSecond) {
        this.expressionFirst = expressionFirst;
        this.expressionSecond = expressionSecond;
    }

    public abstract Expression create(Expression expressionFirst, Expression expressionSecond);


    public abstract double action(double number1, double number2);

    public abstract String operator();

    @Override
    public String toString() {
        return String.format("(%s%s%s)", expressionFirst.toString(), operator(), expressionSecond.toString());
    }


    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return action(expressionFirst.evaluate(assignment), expressionSecond.evaluate(assignment));
    }

    @Override
    public double evaluate() throws Exception {
        return action(expressionFirst.evaluate(), expressionSecond.evaluate());
    }

    @Override
    public List<String> getVariables() {
        List<String> variables = new ArrayList<>();
        if (expressionFirst.getVariables() != null) {
            variables.addAll(expressionFirst.getVariables());
        }
        if (expressionSecond.getVariables() != null) {
            variables.addAll(expressionSecond.getVariables());
        }
        return variables;
    }

    public Expression simpNum(Expression expression1, Expression expression2) {
        Expression expressionOne = expression1;
        Expression expressionTwo = expression2;
        try {
            expressionOne = new Num(expression1.evaluate());


        } catch (Exception ignored) {

        }
        try {
            expressionTwo = new Num(expression2.evaluate());


        } catch (Exception ignored) {

        }
        try {
            return new Num(action(expressionOne.evaluate(), expressionTwo.evaluate()));


        } catch (Exception ignored) {

        }
        return create(expressionOne.simplify(), expressionTwo.simplify());

    }

    public Expression assign(String var, Expression expression) {
        return create(this.expressionFirst.assign(var, expression), this.expressionSecond.assign(var, expression));
    }

    public Expression getExpressionFirst() {
        return expressionFirst;
    }

    public Expression getExpressionSecond() {
        return expressionSecond;
    }

    @Override
    public boolean equals(Expression expression1) {
        return this.toString().compareTo(expression1.toString()) == 0;
    }


    public boolean equalsTooOne() {
        try {
            double exp = Double.parseDouble(this.toString());
            return exp == 1;
        } catch (Exception e) {

        }
        return false;
    }


    public boolean equalsTooZero() {
        try {
            double exp = Double.parseDouble(this.toString());
            return exp == 0.0;
        } catch (Exception e) {

        }
        return false;
    }

    public void firstAndSecond(Expression expression1, Expression expression2) {
        this.expressionFirst = expression1;
        this.expressionSecond = expression2;
    }

    @Override
    public boolean isNeg() {
        return false;
    }

    @Override
    public Expression getExpression() {
        return null;
    }

}
