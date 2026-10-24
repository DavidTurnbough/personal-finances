/**
 * TransactionService. Used to perform business logic on personal-finances.
 *
 * @author David Turnbough
 */
package turnbough.transactions.services;

import turnbough.transactions.repositories.TransactionRepository;

public class TransactionService
{
	TransactionRepository transactionRepository;

	/**
	 *
	 * @param transactionRepository Used to perform database queries.
	 */
	public TransactionService(TransactionRepository transactionRepository)
	{
		this.transactionRepository = transactionRepository;
	}


}
