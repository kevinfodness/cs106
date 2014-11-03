/**
 * A class containing a program to parse financial data and perform reporting.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class Project4C {

	/**
	 * Main method. Responsible for primary controller routing.
	 * 
	 * @param args Arguments passed to the program on the command-line.
	 */
	public static void main(String[] args) {
		TransactionReader tr = new TransactionReader("src/input.txt");
		tr.analyze();
	}
}