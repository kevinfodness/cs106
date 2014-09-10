/**
 * A program to calculate tips based on various scenarios.
 * 
 * @author Kevin Fodness <kevin@kevinfodness.com>
 * @version 1.0
 */
public class TipCalculator {

	/**
	 * Constructor function. Initializes the program.
	 * 
	 * @param args Arguments passed to the constructor.
	 */
	public static void main(String[] args) {
		restaurantTip(20.00);
	}
	
	/**
	 * A function to calculate a tip for a restaurant.
	 * 
	 * @param total The total of the bill at the restaurant.
	 */
	public static void restaurantTip(double total) {
		
		/* Calculate the tip amount. */
		double tipAmount = total * 0.20;
		
		/* Print the tip amount in a user-friendly way. */
		System.out.print("$" + tipAmount);
	}
}