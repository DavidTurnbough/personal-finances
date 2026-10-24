package turnbough.transactions.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	 *
	 * @param transactionRepository Used to perform database queries.
	 */
	public TransactionService(TransactionRepository transactionRepository)
	{
		this.transactionRepository = transactionRepository;
	}

	public Page<Transaction> getAllTransactions(Pageable pageable)
	{
		Page<Transaction> page = transactionRepository.findAll(pageable);

		if(page.isEmpty())
		{
			log.info("No transactions found for the requested page");
		}

		return page;
	}




}
