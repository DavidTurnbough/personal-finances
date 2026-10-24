package turnbough.transactions.models;

/**
 * TransactionType. Used to constrain available transaction types.
 *
 * @author David Turnbough
 */
public enum TransactionType
{
	DEPOSIT("Deposit", true),
	WITHDRAW("Withdraw", false),
	CREDIT("Credit", true),
	TRANSFER("Transfer", false);

	private final String displayName;
	private final boolean increasesBalance;

	/**
	 *
	 * @param displayName the human-readable name of the transaction type
	 * @param increasesBalance true if the transaction type increases the account balance
	 */
	TransactionType(String displayName, boolean increasesBalance)
	{
		this.displayName = displayName;
		this.increasesBalance = increasesBalance;
	}

	/**
	 *
	 * @return the transaction type
	 */
	public String getDisplayName()
	{
		return this.displayName;
	}

	/**
	 *
	 * @return true if the transfer type increases the account balance
	 */
	public boolean increasesBalance()
	{
		return increasesBalance;
	}

}
