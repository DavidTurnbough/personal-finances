package turnbough.transactions.services;

import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import turnbough.transactions.models.Transaction;
import turnbough.transactions.repositories.TransactionRepository;


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
	 *
	 * @return A database record of a transaction.
	 */
	public Transaction getTransactionById(Long transactionId)
	{
		return transactionRepository.findById(transactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Transaction not found with id: " + transactionId));
	}

	/**
	 * Adds a transaction record to the database.
	 *
	 * @param transaction The transaction to be added to the database.
	 *
	 * @return The transaction after it is saved to the database.
	 */
	@Transactional
	public Transaction addTransaction(Transaction transaction)
	{
		return transactionRepository.save(transaction);
	}

	/**
	 * Updates an existing transaction in the database.
	 *
	 * @param transaction A transaction object containing the information to be updated.
	 *
	 * @return The transaction after being updated.
	 *
	 * @throws ResourceNotFoundException Thrown when the ID of the transaction be updated doesn't exist in the
	 * database.
	 */
	@Transactional
	public Transaction updateTransaction(Transaction transaction)
	{
		if (!transactionRepository.existsById(transaction.getTransactionId()))
		{
			throw new ResourceNotFoundException("Transaction not found with id: " + transaction.getTransactionId());
		}

		return transactionRepository.save(transaction);
	}

	/**
	 * Removes a transaction from the database with the given ID.
	 *
	 * @param transactionId The ID of the transaction to delete from the database.
	 */
	@Transactional
	public void deleteTransaction(Long transactionId)
	{
		if (!transactionRepository.existsById(transactionId))
		{
			throw new ResourceNotFoundException("Transaction not found with id: " + transactionId);
		}

		transactionRepository.deleteById(transactionId);
	}
}
