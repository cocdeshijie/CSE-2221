import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 *
 * Put a short phrase describing the program here.
 *
 * @author Michael Ma
 *
 */
public final class Hailstone4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone4() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * {@code NaturalNumber}.
     *
     * @param n
     *            the starting natural number
     * @param out
     *            the output stream
     * @updates out.content
     * @requires n > 0 and out.is_open
     * @ensures out.content = #out.content * [the Hailstone series starting with
     *          n]
     */
    private static void generateSeries(NaturalNumber n, SimpleWriter out) {
        NaturalNumber num = new NaturalNumber2(n);
        NaturalNumber zero = new NaturalNumber2(0);
        NaturalNumber one = new NaturalNumber2(1);
        NaturalNumber two = new NaturalNumber2(2);
        NaturalNumber three = new NaturalNumber2(3);
        out.print(num + ", ");
        NaturalNumber size = new NaturalNumber2(one);
        NaturalNumber max = new NaturalNumber2(zero);
        while (num.compareTo(one) > 0) {
            NaturalNumber temp1 = new NaturalNumber2(num);
            NaturalNumber temp2 = new NaturalNumber2(temp1.divide(two));
            if (temp2.isZero()) {
                num.divide(two);
            } else {
                num.multiply(three);
                num.increment();
            }
            out.print(num);
            size.increment();
            if (num.compareTo(max) > 0) {
                max = new NaturalNumber2(num);
            }
            if (num.compareTo(one) != 0) {
                out.print(", ");
            }
        }
        out.println("\nThe size of the series is " + size.toString());
        out.println("\nThe maximum value of the series is " + max.toString());

    }

    /**
     * Repeatedly asks the user for a positive integer until the user enters
     * one. Returns the positive integer.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive integer entered by the user
     */
    private static NaturalNumber getPositiveInteger(SimpleReader in,
            SimpleWriter out) {
        int x = -1;
        while (x < 0) {
            out.println("Enter an integer greater than 0: ");
            String line = in.nextLine();
            if (FormatChecker.canParseInt(line)) {
                x = Integer.parseInt(line);
            }
        }
        return new NaturalNumber2(x);
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
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        NaturalNumber startValue = getPositiveInteger(in, out);
        generateSeries(startValue, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
