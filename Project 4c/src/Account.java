import java.util.ArrayList;

/**
 * A class to store a list of transactions associated with an account.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class Account {
	
	/* A variable to keep track of the name of this account. */
	private String name;
	
	/* A variable to keep track of the opening balance. */
	private double openingBalance;

	/* A variable to keep track of the transactions associated with this account. */
	private ArrayList<Transaction> transactions;
	
	/**
	 * Constructor function. Sets the name of the account.
	 * 
	 * @param name The name of the account.
	 */
	public Account(String name) {
		this.name = name;
		this.transactions = new ArrayList<Transaction>();
	}
	
	/**
	 * A method to add a transaction to the transaction list.
	 * 
	 * @param t The transaction to add.
	 */
	public void addTransaction(Transaction t) {
		this.transactions.add(t);
	}
	
	/**
	 * A method to return the name of the account.
	 * 
	 * @return String The name of the account.
	 */
	public String getName() {
		return this.name;
	}
	
	/** 
	 * A method to return the total of the account.
	 * 
	 * @return double The total of the transactions in the account.
	 */
	public double getTotal() {
		double total = this.openingBalance;
		for (Transaction t : this.transactions) {
			total += t.getAmount();
		}

		return total;
	}
	
	/**
	 * A method to set the opening balance.
	 * 
	 * @param openingBalance The opening balance to set.
	 * 
	 * @return void
	 */
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
}
