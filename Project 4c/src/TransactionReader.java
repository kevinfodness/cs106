import java.io.*;
import java.util.*;

/**
 * A class to process transactions loaded in a file.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class TransactionReader {

	/* A variable to track accounts. */
	private ArrayList<Account> accounts;
	
	/* A variable to track the input file being used. */
	private File input;
	
	/**
	 * Constructor function. Used to initialize the transaction reader with a filepath.
	 * 
	 * @param filePath The path to the file to load.
	 */
	public TransactionReader(String filePath) {
		
		/* Initialize the ArrayList. */
		this.accounts = new ArrayList<Account>();
		
		/* Initialize the File object with the filepath. */
		this.input = new File(filePath);
		
		/* Read in the contents of the input file to the lists. */
		this.load();
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
				
				/* Keep track of whether the account was found or not. */
				boolean found = false;

				/* Augment data structures based on line data. */
				for (Account a : this.accounts) {
					if (a.getName().equalsIgnoreCase(line[1])) {
						
						/* Indicate that this account was found. */
						found = true;
						
						/* Add the transaction or the opening balance, based on type. */
						if (line[2].equalsIgnoreCase("Opening Balance")) {
							a.setOpeningBalance(t.getAmount());
						} else {
							a.addTransaction(t);
						}
					}
				}
				
				/* If the account wasn't found, add it. */
				if (!found) {
					Account a = new Account(line[1]);
					a.addTransaction(t);
					this.accounts.add(a);
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
		for (Account a : this.accounts) {
			System.out.println("Total of " + a.getName() + ": $" + a.getTotal());
		}
	}
}
