/*
 * PURPOSE: Entity used for account contact and financial information.
 * AUTHOR: David Turnbough
 */

package turnbough.accounts.models;


import jakarta.persistence.*;

import java.math.BigDecimal;

/*
 * CLASS: Account
 */
@Entity
public class Account
{
	/*
	 * VARIABLES
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long accountId;
	private String accountName;
	private String accountAddress;
	private String accountEmail;
	private String accountPhone;
	private BigDecimal accountBalance;
	private BigDecimal accountInterest;

	@Enumerated(EnumType.STRING)
	private AccountType accountType;


	/*
	 * CONSTRUCTORS
	 */
	public Account()
	{
	}

	public Account(Long accountId, String accountName, String accountAddress, String accountEmail, String accountPhone,
	               AccountType accountType, BigDecimal accountBalance, BigDecimal accountInterest)
	{
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountAddress = accountAddress;
		this.accountEmail = accountEmail;
		this.accountPhone = accountPhone;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.accountInterest = accountInterest;
	}

	/*
	 * GETTERS
	 */
	public Long getAccountId()
	{
		return accountId;
	}

	public String getAccountName()
	{
		return accountName;
	}

	public String getAccountAddress()
	{
		return accountAddress;
	}

	public String getAccountEmail()
	{
		return accountEmail;
	}

	public String getAccountPhone()
	{
		return accountPhone;
	}

	public AccountType getAccountType()
	{
		return accountType;
	}

	public BigDecimal getAccountBalance()
	{
		return accountBalance;
	}

	public BigDecimal getAccountInterest()
	{
		return accountInterest;
	}

	/*
	 * SETTERS
	 */
	public void setAccountId(Long accountId)
	{
		this.accountId = accountId;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public void setAccountAddress(String accountAddress)
	{
		this.accountAddress = accountAddress;
	}

	public void setAccountEmail(String accountEmail)
	{
		this.accountEmail = accountEmail;
	}

	public void setAccountPhone(String accountPhone)
	{
		this.accountPhone = accountPhone;
	}

	public void setAccountType(AccountType accountType)
	{
		this.accountType = accountType;
	}

	public void setAccountBalance(BigDecimal accountBalance)
	{
		this.accountBalance = accountBalance;
	}

	public void setAccountInterest(BigDecimal accountInterest)
	{
		this.accountInterest = accountInterest;
	}

	/*
	 * MISC. METHODS
	 */
	@Override
	public String toString()
	{
		return "Account{" +
				"accountId=" + accountId +
				", accountName='" + accountName + '\'' +
				", accountAddress='" + accountAddress + '\'' +
				", accountEmail='" + accountEmail + '\'' +
				", accountPhone='" + accountPhone + '\'' +
				", accountType='" + accountType + '\'' +
				", accountBalance=" + accountBalance +
				", accountInterest=" + accountInterest +
				'}';
	}
}
