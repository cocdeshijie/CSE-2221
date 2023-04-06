import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Michael Ma
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        // TODO - fill in body
        NaturalNumber result = new NaturalNumber2(0);
        NaturalNumber[] values = new NaturalNumber[2];

        /*
         * Since each operator tag only have exactly 2 children, save each value
         * and their possible children into an array to save if statements.
         */
        for (int i = 0; i < exp.numberOfChildren(); i++) {
            if (!"number".equals(exp.child(i).label())) {
                values[i] = evaluate(exp.child(i));
            } else {
                /*
                 * Cannot be negative value
                 */
                if (Integer
                        .parseInt(exp.child(i).attributeValue("value")) < 0) {
                    Reporter.fatalErrorToConsole(
                            "Negative values detected, NaturalNumber cannot be negative.");
                }
                values[i] = new NaturalNumber2(
                        Integer.parseInt(exp.child(i).attributeValue("value")));
            }
        }

        if ("plus".equals(exp.label())) {
            result = values[0];
            result.add(values[1]);
        }
        if ("minus".equals(exp.label())) {
            /*
             * Cannot subtract to result negative value
             */
            if (values[0].compareTo(values[1]) < 0) {
                Reporter.fatalErrorToConsole(
                        "Result is negativ, NaturalNumber cannot be negative.");
            }
            result = values[0];
            result.subtract(values[1]);
        }
        if ("times".equals(exp.label())) {
            result = values[0];
            result.multiply(values[1]);
        }
        if ("divide".equals(exp.label())) {
            /*
             * Cannot divide by 0
             */
            if (values[1].isZero()) {
                Reporter.fatalErrorToConsole(
                        "Denominator is 0, cannot divide by 0.");
            }
            result = values[0];
            result.divide(values[1]);
        }
        if ("mod".equals(exp.label())) {
            NaturalNumber result2 = new NaturalNumber2(values[0]);
            result = result2.divide(values[1]);
        }
        if ("power".equals(exp.label())) {
            result = values[0];
            result.power(values[1].toInt());
        }
        if ("root".equals(exp.label())) {
            /*
             *
             */
            if (values[1].isZero()) {
                Reporter.fatalErrorToConsole("0th root is undefined.");
            }
            result = values[0];
            result.root(values[1].toInt());
        }
        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return result;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}