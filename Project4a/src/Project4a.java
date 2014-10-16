/* Import utilities and IO for Scanner and File. */
import java.util.*;
import java.io.*;

/**
 * A program to store a transaction list in arrays and calculate the total balance.
 * 
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class Project4a {

	/**
	 * The main method. Does all the things.
	 * 
	 * @param args Arguments passed to the program.
	 * 
	 * @throws FileNotFoundException
	 * 
	 * @return void
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		/* Count the number of lines in the file. */
		int numLines = 0;
		Scanner fileReader = new Scanner(new File("../../Downloads/input.txt"));
		while (fileReader.hasNextLine()) {
			fileReader.nextLine();
			numLines++;
		}
		fileReader.close();

		/* Provision arrays to hold the values based on the number of lines in the file. */
		String[] dates = new String[numLines];
		String[] accounts = new String[numLines];
		String[] transactions = new String[numLines];
		double[] amounts = new double[numLines];
		
		/* Populate the arrays from the file. */
		int i = 0;
		fileReader = new Scanner(new File("../../Downloads/input.txt"));
		while (fileReader.hasNext()) {
			
			/* Get the date (first element). */
			dates[i] = fileReader.next();
			
			/* Get the account type. */
			accounts[i] = fileReader.next();
			
			/* If the account type is Credit, also add the next word ("Card") */
			if (accounts[i].equals("Credit")) {
				accounts[i] = accounts[i] + " " + fileReader.next();
			}
			
			/* Get the transaction type. */
			transactions[i] = fileReader.next();
			
			/* If the transaction type is Opening, also add the next word ("Balance") */
			if (transactions[i].equals("Opening")) {
				transactions[i] = transactions[i] + " " + fileReader.next();
			}
			
			/* Get the amount. */
			amounts[i] = fileReader.nextDouble();
			
			/* Increment index. */
			i++;
		}
		fileReader.close();
		
		/* Declare variables to track the totals in each account. */
		double checking = 0.0;
		double savings = 0.0;
		double credit = 0.0;

		/* Calculate totals. */
		for (i = 0; i < dates.length; i++) {
			
			/* Fork for the account type, to increment the proper variable. */
			if (accounts[i].equals("Checking")) {
				
				/* If the transaction type is a withdrawal, subtract - otherwise add. */
				if (transactions[i].equals("Withdrawal")) {
					checking -= amounts[i];
				} else {
					checking += amounts[i];
				}
			} else if (accounts[i].equals("Savings")) {

				/* If the transaction type is a withdrawal, subtract - otherwise add. */
				if (transactions[i].equals("Withdrawal")) {
					savings -= amounts[i];
				} else {
					savings += amounts[i];
				}
			} else {
				
				/* If the transaction type is a withdrawal, subtract - otherwise add. */
				if (transactions[i].equals("Withdrawal")) {
					credit -= amounts[i];
				} else {
					credit += amounts[i];
				}
			}
		}
		
		/* Print totals to the screen. */
		System.out.println("Checking balance: $" + checking);
		System.out.println("Savings balance: $" + savings);
		System.out.println("Credit Card balance: $" + credit);
	}

}
