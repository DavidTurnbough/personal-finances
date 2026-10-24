package turnbough.transactions.models;

/**
 * TransactionType. Used to constrain available transaction types.
 *
 * @author David Turnbough
 */
public enum TransactionType
{
	DEBIT("Debit"),
	CREDIT_CARD("Credit Card"),
	PAYMENT_PLAN("Payment Plan");

	private final String displayName;

	/**
	 *
	 * @param displayName the human-readable name of the transaction type
	 */
	TransactionType(String displayName)
	{
		this.displayName = displayName;
	}

	/**
	 *
	 * @return the transaction type
	 */
	public String getDisplayName()
	{
		return this.displayName;
	}



}
