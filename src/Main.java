
import Binary.Mult;
import Binary.Plus;
import Binary.Pow;
import Unary.Sin;
import interfaces.Expression;
import elements.Num;
import elements.Var;

import java.util.Map;
import java.util.TreeMap;


/**
 * Main class to demonstrate expression evaluation, differentiation, and simplification.
 */
public class Main {
    /**
     * Main method.
     *
     * @param args Command-line arguments.
     * @throws Exception If an error occurs during execution.
     */
    public static void main(String[] args) throws Exception {
        // Expression
        Expression expression = new Plus(new Plus(new Mult(new Num(2), new Var("x")),
                new Sin(new Mult(new Num(4), new Var("y")))),
                new Pow(new Var("e"), new Var("x")));
        System.out.println(expression);

        // Evaluation
        Map<String, Double> assignment = new TreeMap<>();
        assignment.put("x", 2.0);
        assignment.put("y", 0.25);
        assignment.put("e", 2.71);
        double result = expression.evaluate(assignment);
        System.out.println(result);

        // Differentiation
        Expression derivative = expression.differentiate("x");
        System.out.println(derivative);

        // Differentiation with Evaluation
        double derivativeEvaluation = derivative.evaluate(assignment);
        System.out.println(derivativeEvaluation);

        // Simplification of Differentiation
        Expression simpleDiff = derivative.simplify();
        System.out.println(simpleDiff);
    }
}