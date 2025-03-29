package Binary;

import Base.BinaryExpression;
import Unary.Neg;
import elements.Num;
import interfaces.Expression;

public class Minus extends BinaryExpression {


    private Expression expressionFirst, expressionSecond;

    public Minus(Expression expressionFirst, Expression expressionSecond) {
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
        return number1 - number2;
    }

    /**
     * @return
     */
    @Override
    public String operator() {
        return " - ";
    }


    @Override
    public Expression differentiate(String var) {
        return new Minus(expressionFirst.differentiate(var), expressionSecond.differentiate(var));
    }

    @Override
    public Expression simplify() {
        if (expressionFirst.simplify().equalsTooZero()) {
            return new Neg(expressionSecond.simplify());
        }
        if (expressionSecond.simplify().equalsTooZero()) {
            return expressionFirst.simplify();
        }
        if (expressionFirst.simplify().equals(expressionSecond.simplify())) {
            return new Num(0);
        }
        if (expressionSecond.toString().startsWith("-")) {
            return new Plus(expressionFirst, new Neg(expressionSecond));
        }
        return super.simpNum(expressionFirst.simplify(), expressionSecond.simplify());

    }
    /**
     * @param expressionFirst
     * @param expressionSecond
     * @return
     */
    @Override
    public Expression create (Expression expressionFirst, Expression
            expressionSecond){
        this.firstAndSecond(expressionFirst, expressionSecond);
        return this;
    }

}

