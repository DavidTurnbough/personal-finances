package turnbough.accounts.models;

/**
 * Keeps track of a transactions status; payable, pending, complete
 *
 * @author David Turnbough
 */
public enum TransactionStatus
{
	PAYABLE("Payable"),
	PENDING("Pending"),
	COMPLETED("Completed"),
	APPROVED("Approved"),
	REJECTED("Rejected"),
	CANCELLED("Cancelled");

	private final String displayName;

	/**
	 *
	 * @param displayName Human-readable name of the transaction status
	 */
	TransactionStatus(String displayName)
	{
		this.displayName = displayName;
	}

	/**
	 *
	 * @return the readable name of the transaction status
	 */
	public String getDisplayName()
	{
		return this.displayName;
	}


}
