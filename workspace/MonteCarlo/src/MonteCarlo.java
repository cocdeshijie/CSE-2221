import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,1.0)
 * interval that fall in the left half subinterval [0.0,0.5).
 */
public final class MonteCarlo {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MonteCarlo() {
    }

    /**
     * Checks whether the given point (xCoord, yCoord) is inside the circle of
     * radius 1.0 centered at the point (1.0, 1.0).
     *
     * @param xCoord
     *            the x coordinate of the point
     * @param yCoord
     *            the y coordinate of the point
     * @return true if the point is inside the circle, false otherwise
     */
    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        double distance = Math.sqrt((xCoord - 1.0) * (xCoord - 1.0)
                + (yCoord - 1.0) * (yCoord - 1.0));
        if (distance < 1) {
            return true;
        }
        return false;
    }

    /**
     * Generates n pseudo-random points in the [0.0,2.0) x [0.0,2.0) square and
     * returns the number that fall in the circle of radius 1.0 centered at the
     * point (1.0, 1.0).
     *
     * @param n
     *            the number of points to generate
     * @return the number of points that fall in the circle
     */
    private static int numberOfPointsInCircle(int n) {
        Random rnd = new Random1L();
        int ptsInInterval = 0, ptsInSubinterval = 0;

        while (ptsInInterval < n) {
            double xCoord = rnd.nextDouble() * 2.0;
            double yCoord = rnd.nextDouble() * 2.0;
            ptsInInterval++;
            if (pointIsInCircle(xCoord, yCoord)) {
                ptsInSubinterval++;
            }
        }
        return ptsInSubinterval;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        /*
         * Open input and output streams
         */
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        /*
         * Ask user for number of points to generate
         */
        output.print("Number of points: ");
        int n = input.nextInteger();
        /*
         * Find how many points is within the range of the circle
         */
        int pointsInCircle = numberOfPointsInCircle(n);
        /*
         * Calculate estimation of π with points in circle and n
         */
        final double area = 4.0;
        double estimate = (area * pointsInCircle) / n;
        output.println("Estimate of circle area: " + estimate);
        /*
         * Close input and output streams
         */
        input.close();
        output.close();
    }

}