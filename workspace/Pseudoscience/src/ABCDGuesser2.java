import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Michael Ma
 *
 */
public final class ABCDGuesser2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser2() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        double input = -1.0;
        while (input <= 0.0) {
            out.println("Please enter a positive real number μ: ");
            String line = in.nextLine();
            if (FormatChecker.canParseDouble(line)) {
                input = Double.parseDouble(line);
            }
        }
        return input;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        double input = -1.0;
        while (input <= 0.0 || input == 1.0) {
            out.println("Please enter a positive real number: ");
            String line = in.nextLine();
            if (FormatChecker.canParseDouble(line)) {
                input = Double.parseDouble(line);
            }
        }
        return input;
    }

    /*
     *
     */
    private static void calculate(double mu, double w, double x, double y,
            double z, SimpleWriter out) {
        double a = 0, b = 0, c = 0, d = 0;
        double powerA, powerB, powerC, powerD;
        final double[] jager = { -5, -4, -3, -2, -1, -1 / 2, -1 / 3, -1 / 4, 0,
                1 / 4, 1 / 3, 1 / 2, 1, 2, 3, 4, 5 };
        double estimate = 0;
        int loopOne = 0, loopTwo = 0, loopThree = 0, loopFour = 0;

        for (loopOne = 0; loopOne < jager.length; loopOne++) {
            powerA = Math.pow(w, jager[loopOne]);
            for (loopTwo = 0; loopTwo < jager.length; loopTwo++) {
                powerB = Math.pow(x, jager[loopTwo]);
                for (loopThree = 0; loopThree < jager.length; loopThree++) {
                    powerC = Math.pow(y, jager[loopThree]);
                    for (loopFour = 0; loopFour < jager.length; loopFour++) {
                        powerD = Math.pow(z, jager[loopFour]);
                        double temp = (powerA * powerB * powerC * powerD);
                        if (Math.abs(mu - temp) < Math.abs(mu - estimate)) {
                            estimate = temp;
                            a = jager[loopOne];
                            b = jager[loopTwo];
                            c = jager[loopThree];
                            d = jager[loopFour];
                        }
                    }
                    loopFour = 0;
                }
                loopThree = 0;
            }
            loopTwo = 0;
        }
        out.println(w + "^" + a + " + " + x + "^" + b + " + " + y + "^" + c
                + " + " + z + "^" + d + " = " + estimate);
        out.print("The error of the calculation is: ");
        out.print((100 - (estimate / mu) * 100), 2, false);
        out.print("%");
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

        double mu;
        double w, x, y, z;

        mu = getPositiveDouble(in, out);
        w = getPositiveDoubleNotOne(in, out);
        x = getPositiveDoubleNotOne(in, out);
        y = getPositiveDoubleNotOne(in, out);
        z = getPositiveDoubleNotOne(in, out);

        calculate(mu, w, x, y, z, out);
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
