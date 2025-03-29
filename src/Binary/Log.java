package Binary;

import Base.BinaryExpression;
import elements.Num;
import elements.Var;
import interfaces.Expression;


public class Log extends BinaryExpression {
    Expression expressionFirst, ExpressionSecond;

    public Log(Expression expressionFirst, Expression expressionSecond) {
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
            return Math.log(number1) / Math.log(number2);
        } catch (NumberFormatException numberFormatException) {
            throw numberFormatException;
        }
    }

    /**
     * @return
     */
    @Override
    public String operator() {
        return null;
    }




    @Override
    public String toString() {
        return "log(" + expressionFirst.toString() + ", " + expressionSecond.toString() + ")";
    }

    @Override
    public Expression differentiate(String var) {
        return new Div(expressionSecond.differentiate(var),
                new Mult(expressionSecond,
                        new Log(
                                new Var("e"), expressionFirst)));
    }

    @Override
    public Expression simplify() {
        if (expressionFirst.simplify().equals(expressionSecond.simplify())) {
            return new Num(1);
        }
        if (expressionSecond.simplify().equalsTooOne()) {
            return new Num(0);
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
