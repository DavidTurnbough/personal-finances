package turnbough.transactions.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import turnbough.transactions.models.Transaction;
import turnbough.transactions.services.TransactionService;

import java.util.List;

/**
 * TransactionController. Used to route API calls.
 *
 * @author David Turnbough
 */
@RestController
@RequestMapping("/transactions")
public class TransactionController
{
	private final TransactionService transactionService;

	/**
	 *
	 * @param transactionService Used to handle the business logic such as repository calls and calculations.
	 */
	public TransactionController(TransactionService transactionService)
	{
		this.transactionService = transactionService;
	}


	@RequestMapping("/all")
	public ResponseEntity<Page<Transaction>> getAllTransactions(@PageableDefault(page = 0, size = 20,
			sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable)
	{
		Page<Transaction> page = transactionService.getAllTransactions(pageable);
		return ResponseEntity.ok(page);
	}
}
