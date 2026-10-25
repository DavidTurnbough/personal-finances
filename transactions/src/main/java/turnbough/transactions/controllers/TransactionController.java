package turnbough.transactions.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import turnbough.transactions.models.Transaction;
import turnbough.transactions.services.TransactionService;

import java.util.List;

/**
 * TransactionController. Used to route API calls.
 *
 * @author David Turnbough
 */
@RestController
@RequestMapping("api/transactions")
public class TransactionController
{
	private final TransactionService transactionService;
	private static final Logger log = LogManager.getLogger(TransactionController.class);


	/**
	 * Constructor.
	 *
	 * @param transactionService Used to handle the business logic such as repository calls and calculations.
	 */
	public TransactionController(TransactionService transactionService)
	{
		this.transactionService = transactionService;
	}

	/**
	 * Retrieve a range of transactions. Defaulted to the last 20 transactions.
	 *
	 * @param pageable An object containing the instructions of which entries to get from the database.
	 * @return A page of transactions. Default results the last 20 transactions if they exist.
	 */
	@GetMapping("/all")
	public ResponseEntity<Page<Transaction>> getAllTransactions(@PageableDefault(page = 0, size = 20,
			sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable)
	{
		Page<Transaction> page = transactionService.getAllTransactions(pageable);
		return ResponseEntity.ok(page);
	}

	/**
	 * Performs a database request for single record with the given transaction Id.
	 *
	 * @param transactionId The transaction ID of the record to be queried.
	 * @return A database record of a transaction.
	 */
	@GetMapping("/{transactionId}")
	public Transaction getTransactionById(@PathVariable Long transactionId)
	{
		return transactionService.getTransactionById(transactionId);

	}

	/**
	 * Adds a transaction record to the database.
	 *
	 * @param transaction The transaction to be stored in the database.
	 * @return The transaction that was saved to the database and an HTTP status indicating that it created.
	 */
	@PostMapping
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction)
	{
		Transaction savedTransaction = transactionService.addTransaction(transaction);

		return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
	}
}
