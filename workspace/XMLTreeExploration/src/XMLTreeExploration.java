import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Put a short phrase describing the program here.
 *
 * @author Michael Ma
 *
 */
public final class XMLTreeExploration {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeExploration() {
    }

    /**
     * Output information about the middle child of the given {@code XMLTree}.
     *
     * @param xt
     *            the {@code XMLTree} whose middle child is to be printed
     * @param out
     *            the output stream
     * @updates out.content
     * @requires <pre>
     * [the label of the root of xt is a tag]  and
     * [xt has at least one child]  and  out.is_open
     * </pre>
     * @ensures <pre>
     * out.content = #out.content * [the label of the middle child
     *  of xt, whether the root of the middle child is a tag or text,
     *  and if it is a tag, the number of children of the middle child]
     * </pre>
     */
    private static void printMiddleNode(XMLTree xt, SimpleWriter out) {
        int midChildIndex = xt.numberOfChildren() / 2;
        XMLTree midChild = xt.child(midChildIndex);
        out.println("The mid child's label is" + midChild.label());
        if (midChild.isTag()) {
            out.println("The mid child's label is a tag.");
            out.println("The mid child have " + midChild.numberOfChildren()
                    + " children.");
        } else {
            out.println("The mid child's label are texts.");
        }
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
        XMLTree xml = new XMLTree1(
                "http://web.cse.ohio-state.edu/software/2221/web-sw1/extras/instructions/xmltree-model/columbus-weather.xml");
        // out.println(xml.toString());
        xml.display();
        out.println("-----------The Root---------------");
        if (xml.isTag()) {
            out.println("The root of the xml is a tag.");
        } else {
            out.println("The root of the xml are texts.");
        }
        out.println(xml.label());
        out.println("----------------------------------");
        out.println("----------The Children-------------");
        XMLTree results = xml.child(0);
        XMLTree channel = results.child(0);
        out.println("There are " + channel.numberOfChildren()
                + " children in XMLTree channel.");
        XMLTree title = channel.child(1);
        XMLTree titleText = title.child(0);
        out.println("The titleText label is: " + titleText.label());
        out.println(
                "One line: " + xml.child(0).child(0).child(1).child(0).label());
        out.println("----------------------------------");
        out.println("----------The Attributes-------------");
        XMLTree astronomy = channel.child(10);
        if (astronomy.hasAttribute("sunset")) {
            out.println("astronomy XMLTree have an attribute named sunset. ");
        }
        if (astronomy.hasAttribute("midday")) {
            out.println("astronomy XMLTree have an attribute named midday. ");
        }
        out.println("sunrise: " + astronomy.attributeValue("sunrise"));
        out.println("sunset: " + astronomy.attributeValue("sunset"));
        out.println("----------------------------------");
        out.println("---------One More Challenge-----------");
        printMiddleNode(channel, out);
        out.println("----------------------------------");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
