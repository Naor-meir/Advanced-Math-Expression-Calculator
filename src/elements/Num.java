package elements;

import Base.BaseExpression;
import interfaces.Expression;

import java.util.List;
import java.util.Map;

public class Num extends BaseExpression {
    private final double num;

    public Num(double num) {
        this.num = num;
    }


    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.num;
    }

    @Override
    public double evaluate() throws Exception {
        return this.num;
    }

    @Override
    public List<String> getVariables() {
        return null;
    }

    @Override
    public Expression differentiate(String var) {
        return new Num(0);
    }

    @Override
    public Expression simplify() {
        return this;
    }

    /**
     * @return
     */
    @Override
    public boolean equalsTooZero() {
        return num == 0;
    }

    /**
     * @return
     */
    @Override
    public boolean equalsTooOne() {
        return num == 1;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return this;
    }

    /**
     * @return
     */
    @Override
    public String baseString() {
        return Double.toString(this.num);
    }


}
