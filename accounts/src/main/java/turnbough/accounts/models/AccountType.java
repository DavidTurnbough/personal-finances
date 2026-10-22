/*
 * PURPOSE: This class is used to restrict the available types of accounts.
 * AUTHOR: David Turnbough
 */
package turnbough.accounts.models;

/*
 * CLASS: AccountType
 * PURPOSE: Used to restrict the account types.
 */
public enum AccountType
{
	/*
	 * CONSTANTS
	 */
	CHECKING("Checking"),
	SAVINGS("Savings"),
	INVESTMENT("Investment"),
	RETIREMENT("Retirement"),
	CREDIT_CARD("Credit Card"),
	UTILITY("Utility"),
	MISC("Misc");

	/*
	 * VARIABLES
	 */
	private final String displayName;

	/*
	 * CONSTRUCTORS
	 */
	AccountType(final String displayName)
	{
		this.displayName = displayName;
	}

	/*
	 * GETTER METHODS
	 */
	public String getDisplayName()
	{
		return this.displayName;
	}
}