package Binary;

import Base.BinaryExpression;
import elements.Num;
import interfaces.Expression;

public class Mult extends BinaryExpression {
    private Expression expressionFirst, expressionSecond;

    public Mult(Expression expressionFirst, Expression expressionSecond) {
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
        return number1 * number2;
    }

    /**
     * @return
     */
    @Override
    public String operator() {
        return " * ";
    }




    @Override
    public Expression differentiate(String var) {
        return new Plus(new Mult(expressionFirst.differentiate(var), expressionSecond), new Mult(expressionFirst, expressionSecond.differentiate(var)));
    }

    @Override
    public Expression simplify() {
        if (expressionFirst.simplify().equalsTooZero() || expressionSecond.simplify().equalsTooZero()) {
            return new Num(0);
        }
        if (expressionFirst.simplify().equalsTooOne()) {
            return expressionSecond.simplify();
        }
        if (expressionSecond.simplify().equalsTooOne()) {
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
