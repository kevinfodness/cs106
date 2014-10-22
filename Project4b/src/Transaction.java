/**
 * A class to represent a financial transaction.
 *
 * @author Kevin Fodness <kevin@kevinfodness.com>
 */
public class Transaction {

	/* A variable to track the date of the transaction. */
	private String date;
	
	/* A variable to track the account type. */
	private String accountType;
	
	/* A variable to track the transaction type. */
	private String transactionType;
	
	/* A variable to track the amount of the transaction. */
	private double amount;
	
	/**
	 * Constructor function. Sets initial values based on provided values.
	 * 
	 * @param initDate				The starting date.
	 * @param initAccountType		The starting account type.
	 * @param initTransactionType	The starting transaction type.
	 * @param initAmount			The starting amount.
	 */
	public Transaction(String initDate, String initAccountType, String initTransactionType, double initAmount) {
		this.date = initDate;
		this.accountType = initAccountType;
		this.transactionType = initTransactionType;
		this.amount = initAmount;
	}
	
	/**
	 * A method to return the adjusted amount based on transaction type.
	 * 
	 * @return double The adjusted amount.
	 */
	public double getAmount() {
		
		/* If the transaction type is a withdrawal, return the amount as negative. */
		if (this.transactionType.equalsIgnoreCase("Withdrawal")) {
			return -1 * this.amount;
		}

		return this.amount;
	}

	/**
	 * A function to determine if the account type is Checking.
	 * 
	 * @return True if the account type is checking, false otherwise.
	 */
	public boolean isChecking() {
		return (this.accountType.equalsIgnoreCase("Checking"));
	}

	/**
	 * A function to determine if the account type is Credit Card.
	 * 
	 * @return True if the account type is Credit Card, false otherwise.
	 */
	public boolean isCreditCard() {
		return (this.accountType.equalsIgnoreCase("Credit Card"));
	}

	/**
	 * A function to determine if the account type is Savings.
	 * 
	 * @return True if the account type is savings, false otherwise.
	 */
	public boolean isSavings() {
		return (this.accountType.equalsIgnoreCase("Savings"));
	}

	/**
	 * A method to convert this object to a String.
	 * 
	 * @return String The stringified object.
	 */
	public String toString() {
		return this.date + "\t" + this.accountType + "\t" + this.transactionType + "\t" + this.amount;
	}
}
