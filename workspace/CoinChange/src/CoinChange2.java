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
public final class CoinChange2 {
    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange2() {
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
         * Put your main program code here
         */

        final int coinTypes = 6;

        out.println("How many cents do you need to change for? ");
        int coins = in.nextInteger();

        final int dollar;
        final int halfDollar;
        final int quarter;
        final int dime;
        final int nickel;
        final int penny;

        final int hundred = 100;
        final int fifty = 50;
        final int twentyFive = 25;
        final int ten = 10;
        final int five = 5;
        final int one = 1;

        dollar = coins / hundred;
        coins = coins % hundred;

        halfDollar = coins / fifty;
        coins = coins % fifty;

        quarter = coins / twentyFive;
        coins = coins % twentyFive;

        dime = coins / ten;
        coins = coins % ten;

        nickel = coins / five;
        coins = coins % five;

        penny = coins / one;
        coins = coins % one;

        out.println(dollar + " Dollars");
        out.println(halfDollar + " half dollars");
        out.println(quarter + " quarters");
        out.println(dime + " dimes");
        out.println(nickel + " nickels");
        out.println(penny + " pennies");

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
