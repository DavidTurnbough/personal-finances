package turnbough.transactions.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import turnbough.transactions.models.Transaction;
import turnbough.transactions.repositories.TransactionRepository;

import java.util.List;

/**
 * TransactionService. Used to perform business logic on personal-finances.
 *
 * @author David Turnbough
 */
@Service
public class TransactionService
{
	private final TransactionRepository transactionRepository;
	private static final Logger log = LogManager.getLogger(TransactionService.class);

	/**
	 * Constructor
	 *
	 * @param transactionRepository Used to perform database queries.
	 */
	public TransactionService(TransactionRepository transactionRepository)
	{
		this.transactionRepository = transactionRepository;
	}

	/**
	 * Queries the database for a group of transactions. Defaults to the last 20 actions.
	 *
	 * @param pageable An object containing the instructions of the database query.
	 * @return A page containing the list of queried transactions.
	 */
	public Page<Transaction> getAllTransactions(Pageable pageable)
	{
		Page<Transaction> page = transactionRepository.findAll(pageable);

		if(page.isEmpty())
		{
			log.info("No transactions found for the requested page");
		}

		return page;
	}

	/**
	 * Queries the database for a transaction with a given ID.
	 *
	 * @param transactionId The ID of the transaction to be queried.
	 * @return A database record of a transaction.
	 */
	public Transaction getTransactionById(Long transactionId)
	{
		return transactionRepository.findById(transactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + transactionId));
	}
}
