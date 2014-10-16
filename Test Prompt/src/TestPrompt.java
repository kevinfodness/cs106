/* Get the scanner to get user input. */
import java.util.Scanner;

/**
 * A class to demonstrate prompting the user for input.
 * 
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class TestPrompt {

	/**
	 * The main method. It does all the things.
	 * 
	 * @param args
	 *            Parameters passed to the program at runtime.
	 */
	public static void main(String[] args) {

		/* Declare variables to keep track of criteria. */
		int impulsive = 0;
		int calculating = 0;
		int manipulative = 0;
		int generous = 0;

		/* Declare a scanner to get user input. */
		Scanner console = new Scanner(System.in);
		
		/* Ask the user if they want to continue. */
		String keepGoing = "y";
		while (keepGoing.equals("y")) {
			System.out.print("Do you want to keep going? ");
			keepGoing = console.nextLine();
		}

		/* Ask me your questions, bridgekeeper. I am not afraid. */
		question1(console, impulsive, calculating, manipulative, generous);

		/* Close the scanner when we are done with it. */
		console.close();
	}

	/**
	 * A method to ask the user the first question and record the results.
	 * 
	 * @param console
	 *            The Scanner object to use to solicit input.
	 * @param impulsive
	 *            How impulsive the user is.
	 * @param calculating
	 *            How calculating the user is.
	 * @param manipulative
	 *            How manipulative the user is.
	 * @param generous
	 *            How generous the user is.
	 * 
	 * @return void
	 */
	public static void question1(Scanner console, int impulsive,
			int calculating, int manipulative, int generous) {

		/* Set up the questions for the user. */
		System.out
				.println("If you were given an opportunity to steal a test, would you?");
		System.out.println("A: Absolutely, without hesitation.");
		System.out.println("B: The risks outweigh the benefits, so no.");
		System.out
				.println("C: If I could trick the other person into it without their knowledge.");
		System.out
				.println("D: Maybe, but I would share the answers with everyone else equally.");
		
		/* Prompt the user for their answer. */
		System.out.print("What is your answer? ");
		String answer = console.nextLine();
		
		/* Determine what variables to augment based on the answer. */
		if (answer.equals("A")) {
			impulsive++;
		} else if (answer.equals("B")) {
			calculating++;
		} else if (answer.equals("C")) {
			manipulative++;
		} else {
			generous++;
		}
		
		/* Kick the control flow to the final calculation. */
		getResults(impulsive, calculating, manipulative, generous);
	}
	
	/**
	 * A method to give the user results at the end of program exeuction.
	 * 
	 * @param impulsive
	 *            How impulsive the user is.
	 * @param calculating
	 *            How calculating the user is.
	 * @param manipulative
	 *            How manipulative the user is.
	 * @param generous
	 *            How generous the user is.
	 *            
	 * @return void
	 */
	public static void getResults(int impulsive, int calculating, int manipulative, int generous) {
		
		/* Determine the user's matching character based on the criteria. */
		if (impulsive > calculating && impulsive > manipulative && impulsive > generous) {
			System.out.println("You are most like Starbuck.");
		} else if (calculating > impulsive && calculating > manipulative && calculating > generous) {
			System.out.println("You are most like Adama.");
		} else if (manipulative > impulsive && manipulative > calculating && manipulative > generous) {
			System.out.println("You are most like Baltar.");
		} else if (generous > impulsive && generous > calculating && generous > manipulative) {
			System.out.println("You are most like Roslin.");
		} else {
			System.out.println("Your results were inconclusive.");
		}
	}
}