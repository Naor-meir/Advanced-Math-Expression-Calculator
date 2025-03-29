package elements;

import Base.BaseExpression;
import interfaces.Expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Var extends BaseExpression {
    private final String var;

    public Var(String var) {
        this.var = var;
    }

    @Override
    public double evaluate(Map<String, Double> assignment) throws Exception {
        return assignment.get(this.var);
    }

    @Override
    public double evaluate() throws Exception {
        throw new NumberFormatException();
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<String>(Collections.singleton(this.var));
    }

    @Override
    public Expression differentiate(String var) {
        if (this.var.equals(var)) {
            return new Num(1);
        }
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
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean equalsTooOne() {
        return false;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (this.var.compareTo(var)==0) {
            return expression;
        }
        return this;
    }

    /**
     * @return
     */
    @Override
    public String baseString() {
        return this.var;
    }

}
