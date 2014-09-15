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
		double tip = getTip(20.00, 0.20);
		System.out.println("$" + tip);
	}
	
	/**
	 * Method to get the tip based on a provided total and percent.
	 * 
	 * @param total   The total of the bill without tip.
	 * @param percent The percentage of the total to give as tip.
	 * 
	 * @return double The amount of the tip.
	 */
	public static double getTip(double total, double percent) {
	    return total * percent;
	}
}
