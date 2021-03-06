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
		
		/* Define the total amount of the bill. */
		double total = 20.00;
		System.out.println(Math.pow(total, 2));
		
		/* Print tips in various contexts. */
		barTip(total);
		deliveryTip(total);
		restaurantTip(total);
		
		barTip2();
	}
	
	public static void barTip2() {
		System.out.println(20.00 * 0.20);
	}
	
	/**
	 * A function to calculate a tip for a drink at a bar.
	 * 
	 * @param total The total of the bill at the bar.
	 */
	public static void barTip(double total) {
		
		/* Calculate the tip amount. */
		double tipAmount = total * 0.25;
		
		/* Print the tip amount in a user-friendly way. */
		System.out.println("Bar tip amount: $" + tipAmount);
	}

	/**
	 * A function to calculate a tip for delivery.
	 * 
	 * @param total The total of the delivery bill.
	 */
	public static void deliveryTip(double total) {
		
		/* Calculate the tip amount. */
		double tipAmount = total * 0.10;
		
		/* Print the tip amount in a user-friendly way. */
		System.out.println("Delivery tip amount: $" + tipAmount);
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
		System.out.println("Restaurant tip amount: $" + tipAmount);
	}
}
