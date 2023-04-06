import static org.junit.Assert.assertEquals;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.queue.Queue;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program to test {@code NaturalNumberInstanceOps} methods subtract and power.
 *
 * @author Paolo Bucci
 *
 */
public final class NaturalNumberTest {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private NaturalNumberTest() {
    }

    /**
     * Get command from user.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return the command entered by the user
     * @updates in.content
     * @updates out.content
     * @requires in.is_open and out.is_open
     * @ensures <pre>
     * [displays a menu of available commands, prompts the user to
     *   enter a command, inputs and returns the command]
     * </pre>
     */
    private static String getCommand(SimpleReader in, SimpleWriter out) {
        out.println();
        out.println("Command: s [subtract]");
        out.println("         p [power]");
        out.print("         q [quit]: ");
        return in.nextLine();
    }

    /**
     * Reports the smallest integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return the smallest integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * min is in entries(q) and
     * for all x: integer
     *     where (x is in entries(q))
     *   (min <= x)
     * </pre>
     */
    private static int min(Queue<Integer> q) {
        assert q.length() != 0 : "Violation of: \"Queue is not empty\"";
        int min = q.front();
        for (int i = 0; i < q.length(); i++) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     * for all x: integer
     *     where (x in in entries(q))
     *   (minAndMax[0] <= x <= minAndMax[1])
     * </pre>
     */
    private static int[] minAndMax(Queue<Integer> q) {
        assert q.length() != 0 : "Violation of: \"Queue is not empty\"";
        int min = q.front(), max = q.front();
        for (int i = 0; i < q.length(); i++) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        return new int[] { min, max };
    }

    private static int[] Noah(Queue<Integer> q) {
        assert q.length() != 0 : "Violation of: \"Queue is not empty\"";
        int[] result = new int[2];
        int min = q.front(), max = q.front();

        // compare

        return result;
    }

    public void test1() {
        NaturalNumber n = new NaturalNumber2(1);
        String output = this.toStringWithCommas(n);
        String expected = "1";
        assertEquals(expected, output);
    }

    public void test2() {
        NaturalNumber n = new NaturalNumber2(1100);
        String output = this.toStringWithCommas(n);
        String expected = "1,100";
        assertEquals(expected, output);
    }

    public void test3() {
        NaturalNumber n = new NaturalNumber2(123456789);
        String output = this.toStringWithCommas(n);
        String expected = "123,456,789";
        assertEquals(expected, output);
    }

    public void test4() {
        NaturalNumber n = new NaturalNumber2(11111111);
        String output = this.toStringWithCommas(n);
        String expected = "11,111,111";
        assertEquals(expected, output);
    }

    private String toStringWithCommas(NaturalNumber n) {
        // TODO Auto-generated method stub
        return null;
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

        String command = getCommand(in, out);
        while (!command.equals("q")) {
            out.println();
            if (command.equals("s")) {
                out.print("Enter first natural number: ");
                NaturalNumber n1 = new NaturalNumberInstanceOps(in.nextLine());
                out.print("Enter second natural number: ");
                NaturalNumber n2 = new NaturalNumberInstanceOps(in.nextLine());
                out.println("Before subtract: n1 = " + n1 + ", n2 = " + n2);
                n1.subtract(n2);
                out.println("After subtract:  n1 = " + n1 + ", n2 = " + n2);
            } else if (command.equals("p")) {
                out.print("Enter a natural number: ");
                NaturalNumber n = new NaturalNumberInstanceOps(in.nextLine());
                out.print("Enter a non-negative integer: ");
                int p = in.nextInteger();
                out.println("Before power: n = " + n);
                n.power(p);
                out.println("After power:  n = " + n);
            } else {
                out.println(command);
            }
            command = getCommand(in, out);
        }

        in.close();
        out.close();
    }

}