/* Import java.util.* to get access to Scanner. */
import java.util.*;

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
		Scanner console = new Scanner(System.in);
		System.out.print("Total amount: ");
		double total = console.nextDouble();
		System.out.println("$" + total);
	}
}
