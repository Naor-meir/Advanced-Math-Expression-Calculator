package Binary;

import Base.BinaryExpression;
import elements.Num;
import interfaces.Expression;

public class Div extends BinaryExpression {
    private Expression expression1, expression2;

    public Div(Expression expression1, Expression expression2) {
        super(expression1, expression2);
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    /**
     * @param number1
     * @param number2
     * @return
     */
    @Override
    public double action(double number1, double number2) {
        if (number2 == 0) {
            throw new NumberFormatException();
        }
        return number1 / number2;
    }

    /**
     * @return
     */
    @Override
    public String operator() {
        return " / ";
    }



    @Override
    public Expression differentiate(String var) {
        return new Div(
                new Minus(
                        new Mult(expression1.differentiate(var), expression2),
                        new Mult(expression1, expression2.differentiate(var))),
                new Pow(expression2,
                        new Num(2)));
    }


    @Override
    public Expression simplify() {
        if (expressionFirst.simplify().equalsTooZero()) {
            return expressionSecond.simplify();
        }
        if (expressionSecond.simplify().equalsTooOne()) {
            return expressionFirst.simplify();
        }
        if (expressionFirst.simplify().equals(expressionSecond.simplify())) {
            return new Num(1);
        }
        return simpNum(expressionFirst.simplify(), expressionSecond.simplify());
    }
    /**
     * @param expressionFirst
     * @param expressionSecond
     * @return
     */
    @Override
    public Expression create(Expression expressionFirst, Expression expressionSecond) {
        this.firstAndSecond(expressionFirst, expressionSecond);
        return this;
    }

}
