package Unary;

import Base.UnaryExpression;
import elements.Num;
import interfaces.Expression;

import java.util.Map;

public class Neg extends UnaryExpression {
    private Expression expression;

    public Neg(Expression expression) {
        super(expression);
        this.expression = expression;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return -1 * this.expression.evaluate(assignment);
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public double evaluate() throws Exception {
        return -1 * this.expression.evaluate();
    }

    @Override
    public String toString() {
        return "(-" + this.expression.toString() + ")";
    }

    public Expression create(Expression expression) {
        this.firstAndSecond(expression);
        return this;
    }


    /**
     * @param var
     * @return
     */
    @Override
    public Expression differentiate(String var) {
        return new Neg(this.expression.differentiate(var));
    }

    /**
     * @return
     */
    @Override
    public Expression simplify() {
        if (this.expression.isNeg()) {
            return this.expression.getExpression().simplify();
        }
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

    @Override
    public boolean isNeg() {
        return true;
    }

    public Expression getExpression() {
        return this.expression;
    }
}



