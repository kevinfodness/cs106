import java.io.*;
import java.util.*;

/**
 * A class to process transactions loaded in a file.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class TransactionReader {

	/* A variable to track checking account transactions. */
	private ArrayList<Transaction> checking;
	
	/* A variable to track credit card transactions. */
	private ArrayList<Transaction> creditCard;
	
	/* A variable to track the input file being used. */
	private File input;
	
	/* A variable to track savings account transactions. */
	private ArrayList<Transaction> savings;
	
	/**
	 * Constructor function. Used to initialize the transaction reader with a filepath.
	 * 
	 * @param filePath The path to the file to load.
	 */
	public TransactionReader(String filePath) {
		
		/* Initialize the ArrayLists. */
		this.checking = new ArrayList<Transaction>();
		this.creditCard = new ArrayList<Transaction>();
		this.savings = new ArrayList<Transaction>();
		
		/* Initialize the File object with the filepath. */
		this.input = new File(filePath);
		
		/* Read in the contents of the input file to the lists. */
		this.load();
	}
	
	/**
	 * A method to get the total of a list of transactions.
	 * 
	 * @param transactions The list of transactions to compute.
	 * 
	 * @return The total.
	 */
	private double getTotal(ArrayList<Transaction> transactions) {
		double total = 0.0;
		for (Transaction t : transactions) {
			total += t.getAmount();
		}
		
		return total;
	}

	/**
	 * A function to read in the contents of the input file to the data structures.
	 * 
	 * @return void
	 */
	private void load() {
		
		/* Try loading in the file into a Scanner. */
		try {
			Scanner fileReader = new Scanner(this.input);
			
			/* Loop through the file, line by line. */
			while (fileReader.hasNextLine()) {
				
				/* Split the line by tabs into a String array. */
				String[] line = fileReader.nextLine().split("\\t");
				
				/* Create transaction type based on line data. */
				Transaction t;
				if (line[2].equalsIgnoreCase("Withdrawal")) {
					t = new Withdrawal(line[0], Double.parseDouble(line[3]));
				} else {
					t = new Deposit(line[0], Double.parseDouble(line[3]));
				}
				
				/* Augment data structures based on line data. */
				if (line[1].equalsIgnoreCase("Checking")) {
					this.checking.add(t);
				} else if (line[1].equalsIgnoreCase("Credit Card")) {
					this.creditCard.add(t);
				} else if (line[1].equalsIgnoreCase("Savings")) {
					this.savings.add(t);
				}
			}
			
			/* Clean up after ourselves. */
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * A method to analyze the contents of the file, loaded into the data structure.
	 * 
	 * @return void
	 */
	public void analyze() {
		System.out.println("Total for checking: $" + this.getTotal(this.checking));
		System.out.println("Total for credit card: $" + this.getTotal(this.creditCard));
		System.out.println("Total for savings: $" + this.getTotal(this.savings));
	}
}
