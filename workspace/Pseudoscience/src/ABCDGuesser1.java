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
public final class ABCDGuesser1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser1() {
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
        double mu;
        double w, x, y, z;
        double a = 0, b = 0, c = 0, d = 0;
        double powerA, powerB, powerC, powerD;
        final double[] jager = { -5, -4, -3, -2, -1, -1 / 2, -1 / 3, -1 / 4, 0,
                1 / 4, 1 / 3, 1 / 2, 1, 2, 3, 4, 5 };
        double estimate = 0;
        int loopOne = 0, loopTwo = 0, loopThree = 0, loopFour = 0;

        mu = getPositiveDouble(in, out);
        w = getPositiveDoubleNotOne(in, out);
        x = getPositiveDoubleNotOne(in, out);
        y = getPositiveDoubleNotOne(in, out);
        z = getPositiveDoubleNotOne(in, out);

        while (loopOne < jager.length) {
            powerA = Math.pow(w, jager[loopOne]);
            while (loopTwo < jager.length) {
                powerB = Math.pow(x, jager[loopTwo]);
                while (loopThree < jager.length) {
                    powerC = Math.pow(y, jager[loopThree]);
                    while (loopFour < jager.length) {
                        powerD = Math.pow(z, jager[loopFour]);
                        double temp = (powerA * powerB * powerC * powerD);
                        if (Math.abs(mu - temp) < Math.abs(mu - estimate)) {
                            estimate = temp;
                            a = jager[loopOne];
                            b = jager[loopTwo];
                            c = jager[loopThree];
                            d = jager[loopFour];
                        }
                        loopFour++;
                    }
                    loopThree++;
                    loopFour = 0;
                }
                loopTwo++;
                loopThree = 0;
            }
            loopOne++;
            loopTwo = 0;
        }

        out.println(w + "^" + a + " + " + x + "^" + b + " + " + y + "^" + c
                + " + " + z + "^" + d + " = " + estimate);
        out.print("The error of the calculation is: ");
        out.print((100 - (estimate / mu) * 100), 2, false);
        out.print("%");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
