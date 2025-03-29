package Unary;

import Base.UnaryExpression;
import Binary.Mult;
import elements.Num;
import interfaces.Expression;

import java.util.Map;

public class Cos extends UnaryExpression {
    private Expression expression;

    public Cos(Expression expression) {
        super(expression);
        this.expression = expression;

    }

    public Expression create(Expression expression) {
        this.firstAndSecond(expression);
        return this;
    }


    /**
     * @param assignment
     * @return
     * @throws Exception
     */
    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return Math.cos(Math.toRadians(expression.evaluate(assignment)));
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public double evaluate() throws Exception {
        return Math.cos(Math.toRadians(expression.evaluate()));
    }

    @Override
    public String toString() {
        return "cos(" + expression.toString() + ")";
    }

    /**
     * @param var
     * @return
     */
    @Override
    public Expression differentiate(String var) {

        return new Neg(new Mult(
                new Sin(expression), expression.differentiate(var)));

    }
    @Override
    public boolean isNeg(){
        return false;
    }

    /**
     * @return
     */
    @Override
    public Expression getExpression() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Expression simplify() {
        try {
            return new Num(this.evaluate());
        } catch (Exception e) {
            return this;
        }
    }

    /**
     * @return
     */
    @Override
    public boolean equalsTooZero() {
        try {
            return new Num(this.evaluate()).equalsTooZero();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * @return
     */
    @Override
    public boolean equalsTooOne() {
        try {
            return new Num(this.evaluate()).equalsTooOne();
        } catch (Exception e) {
            return false;
        }
    }
}



