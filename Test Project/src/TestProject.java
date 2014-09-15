/**
 * A project in which to test code before adding it to lecture slides.
 * 
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class TestProject {

	/**
	 * The main method, responsible for doing all the things.
	 * 
	 * @param args Arguments passed to the program.
	 */
	public static void main(String[] args) {
		printTip(20.00, 0.20);
	}
	
	/**
	 * Method to print the tip based on a provided total.
	 * 
	 * @param total The total of the bill without tip.
	 */
	public static void printTip(double total, double percent) {
	    double tip = total * percent;
	    System.out.println("$" + tip);
	}
}
