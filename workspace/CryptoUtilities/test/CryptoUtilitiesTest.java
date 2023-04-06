import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Michael Ma
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber nExpected = new NaturalNumber2(3);
        NaturalNumber m = new NaturalNumber2(21);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_7_5() {
        NaturalNumber n = new NaturalNumber2(7);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(5);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    @Test
    public void testReduceToGCD_1746_42() {
        NaturalNumber n = new NaturalNumber2(1746);
        NaturalNumber nExpected = new NaturalNumber2(6);
        NaturalNumber m = new NaturalNumber2(42);
        NaturalNumber mExpected = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals(nExpected, n);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_123456789() {
        NaturalNumber n = new NaturalNumber2(123456789);
        NaturalNumber nExpected = new NaturalNumber2(123456789);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void testIsEven_23000() {
        NaturalNumber n = new NaturalNumber2(23000);
        NaturalNumber nExpected = new NaturalNumber2(23000);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber pExpected = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        NaturalNumber mExpected = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber nExpected = new NaturalNumber2(1);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber pExpected = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        NaturalNumber mExpected = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_8_8_8() {
        NaturalNumber n = new NaturalNumber2(8);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(8);
        NaturalNumber pExpected = new NaturalNumber2(8);
        NaturalNumber m = new NaturalNumber2(8);
        NaturalNumber mExpected = new NaturalNumber2(8);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    @Test
    public void testPowerMod_2147483647_1_2147483647() {
        NaturalNumber n = new NaturalNumber2(2147483647);
        NaturalNumber nExpected = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(1);
        NaturalNumber pExpected = new NaturalNumber2(1);
        NaturalNumber m = new NaturalNumber2(2147483647);
        NaturalNumber mExpected = new NaturalNumber2(2147483647);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals(nExpected, n);
        assertEquals(pExpected, p);
        assertEquals(mExpected, m);
    }

    /*
     * Tests of isWitnessToCompositeness
     */

    @Test
    public void isWitnessToCompositeness_111_222() {
        NaturalNumber w = new NaturalNumber2(111);
        NaturalNumber wExpected = new NaturalNumber2(111);
        NaturalNumber n = new NaturalNumber2(222);
        NaturalNumber nExpected = new NaturalNumber2(222);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(true, result);
    }

    @Test
    public void isWitnessToCompositeness_7_11() {
        NaturalNumber w = new NaturalNumber2(7);
        NaturalNumber wExpected = new NaturalNumber2(7);
        NaturalNumber n = new NaturalNumber2(11);
        NaturalNumber nExpected = new NaturalNumber2(11);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    @Test
    public void isWitnessToCompositeness_53_59() {
        NaturalNumber w = new NaturalNumber2(53);
        NaturalNumber wExpected = new NaturalNumber2(53);
        NaturalNumber n = new NaturalNumber2(59);
        NaturalNumber nExpected = new NaturalNumber2(59);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertEquals(wExpected, w);
        assertEquals(nExpected, n);
        assertEquals(false, result);
    }

    /*
     * Tests of isPrime1
     */

    @Test
    public void isPrime1_100() {
        NaturalNumber w = new NaturalNumber2(100);
        NaturalNumber wExpected = new NaturalNumber2(100);
        boolean result = CryptoUtilities.isPrime1(w);
        assertEquals(wExpected, w);
        assertEquals(false, result);
    }

    @Test
    public void isPrime1_111() {
        NaturalNumber w = new NaturalNumber2(111);
        NaturalNumber wExpected = new NaturalNumber2(111);
        boolean result = CryptoUtilities.isPrime1(w);
        assertEquals(wExpected, w);
        assertEquals(false, result);
    }

    @Test
    public void isPrime1_13() {
        NaturalNumber w = new NaturalNumber2(13);
        NaturalNumber wExpected = new NaturalNumber2(13);
        boolean result = CryptoUtilities.isPrime1(w);
        assertEquals(wExpected, w);
        assertEquals(true, result);
    }

    @Test
    public void isPrime1_2147483647() {
        NaturalNumber w = new NaturalNumber2(2147483647);
        NaturalNumber wExpected = new NaturalNumber2(2147483647);
        boolean result = CryptoUtilities.isPrime1(w);
        assertEquals(wExpected, w);
        assertEquals(true, result);
    }

    /*
     * Tests of isPrime2
     */

    @Test
    public void isPrime2_2() {
        NaturalNumber w = new NaturalNumber2(2);
        NaturalNumber wExpected = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(true, result);
    }

    @Test
    public void isPrime2_3() {
        NaturalNumber w = new NaturalNumber2(3);
        NaturalNumber wExpected = new NaturalNumber2(3);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(true, result);
    }

    @Test
    public void isPrime2_15() {
        NaturalNumber w = new NaturalNumber2(15);
        NaturalNumber wExpected = new NaturalNumber2(15);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(false, result);
    }

    @Test
    public void isPrime2_2147483647() {
        NaturalNumber w = new NaturalNumber2(2147483647);
        NaturalNumber wExpected = new NaturalNumber2(2147483647);
        boolean result = CryptoUtilities.isPrime2(w);
        assertEquals(wExpected, w);
        assertEquals(true, result);
    }

    /*
     * Tests of generateNextLikelyPrime
     */

    @Test
    public void generateNextLikelyPrime_15() {
        NaturalNumber w = new NaturalNumber2(15);
        NaturalNumber wExpected = new NaturalNumber2(17);
        CryptoUtilities.generateNextLikelyPrime(w);
        assertEquals(wExpected, w);
    }

    @Test
    public void generateNextLikelyPrime_28() {
        NaturalNumber w = new NaturalNumber2(28);
        NaturalNumber wExpected = new NaturalNumber2(29);
        CryptoUtilities.generateNextLikelyPrime(w);
        assertEquals(wExpected, w);
    }

    @Test
    public void generateNextLikelyPrime_11() {
        NaturalNumber w = new NaturalNumber2(11);
        NaturalNumber wExpected = new NaturalNumber2(11);
        CryptoUtilities.generateNextLikelyPrime(w);
        assertEquals(wExpected, w);
    }

    @Test
    public void generateNextLikelyPrime_2147483646() {
        NaturalNumber w = new NaturalNumber2(2147483646);
        NaturalNumber wExpected = new NaturalNumber2(2147483647);
        CryptoUtilities.generateNextLikelyPrime(w);
        assertEquals(wExpected, w);
    }

}