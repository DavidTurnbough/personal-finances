/*
 * PURPOSE: Performs the logic of the application: Runs any algorithms or routes any database queries.
 * AUTHOR: David Turnbough
 */
package turnbough.accounts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turnbough.accounts.models.Account;
import turnbough.accounts.repositories.AccountRepository;

import java.util.List;
import java.util.Scanner;

/*
 * CLASS: Account Service
 */
@Service
public class AccountService
{

	/*
	 * VARIABLES
	 */
	private final AccountRepository accountRepository;

	/*
	 * CONSTRUCTORS
	 */
	public AccountService(AccountRepository accountRepository)
	{
		this.accountRepository = accountRepository;
	}

	/*
	 * GET SERVICES
	 */
	// @RETURN A list of all accounts, otherwise throws an error.
	public List<Account> getAllAccounts()
	{
		// Ensures there are accounts present.
		if(accountRepository.findAll().isEmpty())
		{
			throw new IllegalStateException("No accounts found.");
		}

		return accountRepository.findAll();
	}

	// @PARAM A unique id for the account to be returned.
	// @RETURN The account with the given id, otherwise returns null.
	public Account getAccountById(Long accountId)
	{
		// TODO: Send message if the account doesn't exist.
		return accountRepository.findById(accountId)
				.orElse(null);
	}

	// @PARAM A name for the account to be returned.
	// @RETURN An account with the given name, otherwise throws an error.
	public Account getAccountByName(String accountName)
	{
		accountName = this.sanitizeInput(accountName);

		if(accountRepository.findByAccountName(accountName) == null)
		{
			throw new IllegalStateException("Account with name " + accountName + " not found.");
		}

		return accountRepository.findByAccountName(accountName);
	}

	// @PARAM The type of accounts to be returned.
	// @RETURN A list of all accounts with the given type, otherwise throws an error.
	public List<Account> getAccountsByAccountType(String accountType)
	{
		String sanitizedAccountType = this.sanitizeInput(accountType);

		// If there are no requested account types, throws an error.
		if(accountRepository.getAccountsByAccountType(sanitizedAccountType) == null)
		{
			throw new IllegalStateException("Account type " + accountType + " not found.");
		}

		// Returns all account types.
		if(sanitizedAccountType.equals("all"))
		{
			return accountRepository.findAll();
		}

		// Returns a list of the requested account types.
		return accountRepository.getAccountsByAccountType(sanitizedAccountType);
	}

	/*
	 * POST SERVICES
	 */
	// Purpose: Creates an account. Throws an error if the account already exists.
	// @Param: An account to be added to the database.
	// @Return: Returns the account information once saved.
	public Account createAccount(Account account)
	{
		// Check to ensure the account doesn't exist. Will throw an error if the account already exists.
		if(accountRepository.existsByAccountName(account.getAccountName()))
		{
			throw new IllegalStateException("An account with this name already exists.");
		}

		return accountRepository.save(account);
	}

	/*
	 * DELETE SERVICES
	 */
	// Purpose: Deletes an account with the given account id. Will only attempt to delete the account if it exists.
	// @Param: The account id to be deleted.
	public void deleteAccountById(Long accountId)
	{
		// Ensures the account exists before attempting to remove it.
		if(accountRepository.existsById(accountId))
		{
			accountRepository.deleteById(accountId);
		}
	}


	// Purpose: Deletes all accounts.
	public void deleteAllAccounts()
	{
		accountRepository.deleteAll();
	}

	/*
	 * MISC SERVICES
	 */
	// Purpose: Sanitizes the passed String; removes all non-alphanumeric values from the passed String, and converts
	//      the string to all lowercase, and capitalizes the first character.
	// @Param: A string to be sanitized.
	// @Return: A String that has been sanitized.
	private String sanitizeInput(String input)
	{
		String sanatizedInput = "";

		sanatizedInput = input.replaceAll("[^a-zA-Z0-9 ]", "");

		sanatizedInput = sanatizedInput.substring(0, 1).toUpperCase()
				+ sanatizedInput.substring(1).toLowerCase();

		return sanatizedInput;
	}

}
