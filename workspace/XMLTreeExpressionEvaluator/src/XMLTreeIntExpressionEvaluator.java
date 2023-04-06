import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Michael Ma
 *
 */
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
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
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        // TODO - fill in body
        int result = 0;
        int[] values = new int[2];

        /*
         * Since each operator tag only have exactly 2 children, save each value
         * and their possible children into an array to save if statements.
         */
        for (int i = 0; i < exp.numberOfChildren(); i++) {
            if (!"number".equals(exp.child(i).label())) {
                values[i] = evaluate(exp.child(i));
            } else {
                values[i] = Integer
                        .parseInt(exp.child(i).attributeValue("value"));
            }
        }

        if ("plus".equals(exp.label())) {
            result = values[0] + values[1];
        }
        if ("minus".equals(exp.label())) {
            result = values[0] - values[1];
        }
        if ("times".equals(exp.label())) {
            result = values[0] * values[1];
        }
        if ("divide".equals(exp.label())) {
            result = values[0] / values[1];
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