/**
 * A class to represent a deposit.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class Deposit extends Transaction {

	/**
	 * Constructor function. Passes arguments to superclass constructor.
	 * 
	 * @param date   The initial date.
	 * @param amount The initial amount.
	 */
	public Deposit(String date, double amount) {
		super(date, amount);
	}
}
