/**
 * A class to represent a transaction.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class Transaction {

	/* A variable to track the date. */
	protected String date;
	
	/* A variable to track the transaction amount. */
	protected double amount;
	
	/**
	 * Constructor function. Sets initial state.
	 * 
	 * @param date   The initial date.
	 * @param amount The initial amount.
	 */
	public Transaction(String date, double amount) {
		this.date = date;
		this.amount = amount;
	}
	
	/**
	 * A function to return the amount.
	 * 
	 * @return The amount of the transaction.
	 */
	public double getAmount() {
		return this.amount;
	}
}
