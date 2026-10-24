package turnbough.transactions.models;

/**
 * TransactionCategory. This class is used to restrict the available options for category types for transaction.
 *
 * @author David Turnbough
 */

public enum TransactionCategory
{
	UTILITIES("Utilities"),
	CREDIT_CARD("CreditCard"),
	PAYMENT_PLAN("PaymentPlan"),
	SUBSCRIPTION("Subscription"),
	ENTERTAINMENT("Entertainment"),
	STUDENT_LOAN("StudentLoan"),
	MEDICAL("Medical"),
	TRANSPORTATION("Transportation"),
	CLOTHING("Clothing"),
	FOOD("Food"),
	TRAVEL("Travel"),
	SAVINGS("Savings"),
	INVESTMENT("Investment"),
	RETIREMENT("Retirement"),
	OTHER("Other");

	private final String displayName;

	/**
	 *
	 * @param displayName The human-readable name of the transaction category
	 */
	TransactionCategory(String displayName)
	{
		this.displayName = displayName;
	}

	/**
	 *
	 * @return The human-readable name for the transaction category
	 */
	public String getDisplayName()
	{
		return this.displayName;
	}
}
