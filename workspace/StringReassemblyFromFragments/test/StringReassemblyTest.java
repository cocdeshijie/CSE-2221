import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    /*
     * Tests of combination
     */

    @Test
    public void combination_CSE2221() {
        String str1 = "CSE22";
        String str2 = "2221";
        int overlap = StringReassembly.overlap(str1, str2);
        String combination = StringReassembly.combination(str1, str2, overlap);
        assertEquals("CSE2221", combination);
    }

    @Test
    public void combination_17_November_2022() {
        String str1 = "17, November";
        String str2 = "November 2022";
        int overlap = StringReassembly.overlap(str1, str2);
        String combination = StringReassembly.combination(str1, str2, overlap);
        assertEquals("17, November 2022", combination);
    }

    /*
     * Tests of addToSetAvoidingSubstrings
     */

    @Test
    public void addToSetAvoidingSubstrings_CSE() {
        Set<String> strSet = new Set1L<String>();
        Set<String> strSetCheck = new Set1L<String>();
        String str1 = "CSE2221";
        String str2 = "MATH1151";
        String str3 = "MATH1172";
        String subStr = "CSE";

        strSet.add(str1);
        strSet.add(str2);
        strSet.add(str3);
        strSetCheck.add(str1);
        strSetCheck.add(str2);
        strSetCheck.add(str3);

        StringReassembly.addToSetAvoidingSubstrings(strSet, subStr);

        assertEquals(strSetCheck, strSet);
    }

    @Test
    public void addToSetAvoidingSubstrings_Date() {
        Set<String> strSet = new Set1L<String>();
        Set<String> strSetCheck = new Set1L<String>();
        String str1 = "17, November 2022";
        String str2 = "16, December 2021";
        String str3 = "15, October 2020";
        String subStr = "September";

        strSet.add(str1);
        strSet.add(str2);
        strSet.add(str3);
        strSetCheck.add(str1);
        strSetCheck.add(str2);
        strSetCheck.add(str3);
        strSetCheck.add(subStr);

        StringReassembly.addToSetAvoidingSubstrings(strSet, subStr);

        assertEquals(strSetCheck, strSet);
    }

    /*
     * Tests of linesFromInput
     */

    @Test
    public void linesFromInput_cheer_8_2() {
        Set<String> inputSet = new Set1L<String>();
        Set<String> testSet = new Set1L<String>();
        SimpleReader input = new SimpleReader1L("data/cheer-8-2.txt");
        String line1 = "Bucks -- Beat";
        String line2 = "Go Bucks";
        String line3 = "o Bucks -- B";
        String line4 = "Beat Mich";
        String line5 = "ichigan~";
        String line6 = "Bucks";
        String line7 = "Michigan~";
        testSet.add(line1);
        testSet.add(line2);
        testSet.add(line3);
        testSet.add(line4);
        // avoid substring
        testSet.add(line7);
        inputSet = StringReassembly.linesFromInput(input);

        assertEquals(inputSet, testSet);
    }

    /*
     * Tests of printWithLineSeparators
     */
    @Test
    public void printWithLineSeparators_CSE() {
        SimpleWriter out = new SimpleWriter1L(
                "data/printWithLineSeparators_CSE.txt");
        SimpleReader in = new SimpleReader1L(
                "data/printWithLineSeparators_CSE.txt");
        String text = "CSE2221~MATH1151~CSE2231~MATH1172";
        String test = "CSE2221" + "\n" + "MATH1151" + "\n" + "CSE2231" + "\n"
                + "MATH1172";
        StringReassembly.printWithLineSeparators(text, out);
        String test1 = in.nextLine();
        String test2 = in.nextLine();
        String test3 = in.nextLine();
        String test4 = in.nextLine();
        in.close();
        out.close();
        assertEquals(test, test1 + "\n" + test2 + "\n" + test3 + "\n" + test4);
    }

    @Test
    public void printWithLineSeparators_Date() {
        SimpleWriter out = new SimpleWriter1L(
                "data/printWithLineSeparators_Date.txt");
        SimpleReader in = new SimpleReader1L(
                "data/printWithLineSeparators_Date.txt");
        String text = "17, November 2022~16, December 2021";
        String test = "17, November 2022" + "\n" + "16, December 2021";
        StringReassembly.printWithLineSeparators(text, out);
        String test1 = in.nextLine();
        String test2 = in.nextLine();
        in.close();
        out.close();
        assertEquals(test, test1 + "\n" + test2);
    }

}
