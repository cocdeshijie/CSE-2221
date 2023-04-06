import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Michael Ma
 *
 */
public final class Newton3 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton3() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @param ep
     *            value of epsilon
     * @return estimate of square root
     */
    private static double sqrt(double x, double ep) {
        final double epsilon = ep;
        final double nonZero = 0.0000000001;
        double estimate = x + nonZero;
        while (Math.abs(estimate - (x / estimate)) > (epsilon * estimate)) {
            estimate = (estimate + (x / estimate)) / 2;
        }
        return estimate;
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
         * Ask user to provide a number to calculate square root and loop if
         * they want to calculate another one
         */
        out.println("Enter the value of ε: ");
        double epsilon = in.nextDouble();
        out.println("Would you like to calculate another square root? y/n ");
        String y = in.nextLine();
        while (y.equals("y")) {
            out.println("Enter a number to calculate square root: ");
            int n = in.nextInteger();
            out.println(sqrt(n, epsilon));
            out.println(
                    "Would you like to calculate another square root? y/n ");
            y = in.nextLine();
        }

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
