//***************************************************
// PURPOSE:
// AUTHOR: David Turnbough
//***************************************************
package turnbough.accounts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import turnbough.accounts.models.Account;
import turnbough.accounts.repositories.AccountRepository;

import java.util.List;
import java.util.Scanner;

//***************************************************
// CLASS: Account Service
//***************************************************
@Service
public class AccountService
{

	//***************************************************
	// VARIABLES
	//***************************************************
	@Autowired
	private AccountRepository accountRepository;

	//***************************************************
	// GET SERVICES
	//***************************************************
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
		return accountRepository.findById(accountId)
				.orElse(null);
	}

	// @PARAM A name for the account to be returned.
	// @RETURN An account with the given name, otherwise throws an error.
	public Account getAccountByName(String accountName)
	{
		//TODO: Sanitize and format input.
		if(accountRepository.findByAccountName(accountName) == null)
		{
			throw new IllegalStateException("Account with name " + accountName + " not found.");
		}

		return accountRepository.findByAccountName(accountName);
	}

	// @PARAM An account type to be returned
	// @RETURN A list of all accounts with the given type, otherwise throws an error.
	public List<Account> getAccountsByAccountType(String accountType)
	{
		String sanatizedAccountType = "";

		sanatizedAccountType = accountType.replaceAll("[^a-zA-Z0-9 ]", "");

		if(sanatizedAccountType.equals("all"))
		{
			return accountRepository.findAll();
		}

		System.out.println(sanatizedAccountType);

		sanatizedAccountType = sanatizedAccountType.substring(0, 1).toUpperCase()
				+ sanatizedAccountType.substring(1).toLowerCase();

		if(accountRepository.getAccountsByAccountType(accountType) == null)
		{
			throw new IllegalStateException("Account type " + accountType + " not found.");
		}

		return accountRepository.getAccountsByAccountType(sanatizedAccountType);
	}

	//***************************************************
	// POST SERVICES
	//***************************************************
	public Account createAccount(Account account)
	{
		if(accountRepository.existsByAccountName(account.getAccountName()))
		{
			throw new IllegalStateException("An account with this name already exists.");
		}

		return accountRepository.save(account);
	}

	//***************************************************
	// DELETE SERVICES
	//***************************************************
	public void deleteAccountById(Long accountId)
	{
		accountRepository.deleteById(accountId);
	}

	public void deleteAllAccounts()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.printf("Are you sure you want to delete all accounts?");

		String answer = "";

		answer = scanner.nextLine();

		if(answer.equalsIgnoreCase("yes"))
		{
			accountRepository.deleteAll();
		}
	}

	//***************************************************
	// MISC. SERVICES
	//***************************************************
	private String sanitizeInput(String input)
	{
		//TODO: Sanitize and format data.
		return null;
	}

}
