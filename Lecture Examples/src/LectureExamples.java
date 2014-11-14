import java.util.*;

/**
 * Contains a class to represent a program to test code for lecture slides.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class LectureExamples {

    /**
     * Main method. Directs control of the program.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        HashMap<String, String> stocks = new HashMap<String, String>();
        stocks.put("AAPL", "Apple, Inc.");
        stocks.put("GE", "General Electric");
        stocks.put("GOOG", "Google");
        Collection<String> values = stocks.values();
        for (String s : values) {
            System.out.println(s);
        }
    }
}