import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Michael Ma
 *
 */
public final class Oddity {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Oddity() {
    }

    /**
     * Returns a modulo b using "clock arithmetic".
     *
     * @param a
     *            the first operand
     * @param b
     *            the modulus
     * @return a modulo b
     * @requires b > 0
     * @ensures mod = a mod b
     */
    private static int mod(int a, int b) {
        int temp = a;
        if (a > 0) {
            while (temp >= b) {
                temp = temp - b;
            }
        } else {
            while (temp <= b) {
                temp = temp + b;
            }
        }
        return temp;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
//        final int[] values = { 8, -4, 3, 0, -5 };
//        int i = 0;
//        while (i < values.length) {
//            int remainder = values[i] % 2;
//            if (remainder == 1) {
//                out.println("odd");
//            } else {
//                out.println("even");
//            }
//            i = i + 1;
//        }

//        double x = 456.0;
//        double y = 100.0 * 4.56;
//        if (x == y) {
//            out.println("equal");
//        } else {
//            out.println("not equal");
//        }

//        final int microsPerDay = 24 * 60 * 60 * 1000 * 1000;
//        final int millisPerDay = 24 * 60 * 60 * 1000;
//        out.println(microsPerDay / millisPerDay);

//        out.println(12345 + 5432l);

        final int a = 67;
        final int b = 24;
        out.println(mod(a, b));

        out.close();
    }

}
