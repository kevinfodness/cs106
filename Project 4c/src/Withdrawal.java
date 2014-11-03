/**
 * A class to represent a withdrawal.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class Withdrawal extends Transaction {

	/**
	 * Constructor function. Passes arguments to superclass constructor.
	 * 
	 * @param date   The initial date.
	 * @param amount The initial amount.
	 */
	public Withdrawal(String date, double amount) {
		super(date, amount);
	}

	/**
	 * A function to return the amount, adjusted to be negative.
	 * 
	 * @return The amount of the transaction.
	 */
	public double getAmount() {
		return -1 * this.amount;
	}
}
