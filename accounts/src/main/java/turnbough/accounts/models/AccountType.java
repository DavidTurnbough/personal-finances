/*
 * PURPOSE:
 * AUTHOR: David Turnbough
 */
package turnbough.accounts.models;

/*
 * CLASS:
 */
public enum AccountType
{
	CHECKING("Checking"),
	SAVINGS("Savings"),
	INVESTMENT("Investment"),
	RETIREMENT("Retirement"),
	CREDIT_CARD("Credit Card"),
	UTILITY("Utility"),
	MISC("Misc");

	private final String displayName;

	AccountType(final String displayName)
	{
		this.displayName = displayName;
	}

	public String getDisplayName()
	{
		return this.displayName;
	}
}