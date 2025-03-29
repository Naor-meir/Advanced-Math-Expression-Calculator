package Binary;

import Base.BinaryExpression;
import elements.Num;
import elements.Var;
import interfaces.Expression;
public class Pow extends BinaryExpression {
    Expression expressionFirst, ExpressionSecond;

    public Pow(Expression expressionFirst, Expression expressionSecond) {
        super(expressionFirst, expressionSecond);
        this.expressionFirst = expressionFirst;
        this.expressionSecond = expressionSecond;

    }

    /**
     * @param number1
     * @param number2
     * @return
     */
    @Override
    public double action(double number1, double number2) {
        try {
            return Math.pow(number1, number2);
        } catch (NumberFormatException numberFormatException) {
            throw numberFormatException;
        }
    }

    /**
     * @return
     */
    @Override
    public String operator() {
        return "^";
    }



    @Override
    public Expression differentiate(String var) {
        return new Mult(
                new Pow(expressionFirst, expressionSecond),
                new Plus(
                        new Mult(expressionFirst.differentiate(var),
                                new Div(expressionSecond, expressionFirst)),
                        new Mult(expressionSecond.differentiate(var),
                                new Log(
                                        new Var("e"), expressionFirst))));
    }

    @Override
    public Expression simplify() {
        if (expressionSecond.simplify().equalsTooZero()) {
            return new Num(1);
        }
        if (expressionSecond.simplify().equalsTooZero()) {
            return expressionFirst.simplify();
        }

        return super.simpNum(expressionFirst.simplify(), expressionSecond.simplify());
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


