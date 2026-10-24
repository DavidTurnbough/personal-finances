package turnbough.transactions.services;

import org.springframework.stereotype.Service;
import turnbough.transactions.repositories.TransactionRepository;

/**
 * TransactionService. Used to perform business logic on personal-finances.
 *
 * @author David Turnbough
 */
@Service
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
