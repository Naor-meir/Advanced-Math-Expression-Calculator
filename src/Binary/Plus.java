package Binary;

import Base.BinaryExpression;
import elements.Num;
import interfaces.Expression;

public class Plus extends BinaryExpression {
    Expression expressionFirst, ExpressionSecond;

    public Plus(Expression expressionFirst, Expression expressionSecond) {
        super(expressionFirst, expressionSecond);
        this.expressionFirst = expressionFirst;
        this.expressionSecond = expressionSecond;

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

    /**
     * @param number1
     * @param number2
     * @return
     */
    @Override
    public double action(double number1, double number2) {
        return number1 + number2;
    }

    /**
     * @return
     */
    @Override
    public String operator() {
        return " + ";
    }


    @Override
    public Expression differentiate(String var) {

        return new Plus(expressionFirst.differentiate(var), expressionSecond.differentiate(var));
    }

    @Override
    public Expression simplify() {
        if (expressionFirst.simplify().equalsTooZero()) {
            return expressionSecond.simplify();
        }
        if (expressionSecond.simplify().equalsTooZero()) {
            return expressionFirst.simplify();
        }
        if (expressionFirst.simplify().toString().compareTo(expressionSecond.simplify().toString()) == 0) {
            return new Mult(expressionSecond, new Num(2)).simplify();
        }
        return super.simpNum(expressionFirst.simplify(), expressionSecond.simplify());
    }

}
