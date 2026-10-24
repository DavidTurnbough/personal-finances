/**
 * TransactionController. Used to route API calls.
 *
 * @author David Turnbough
 */
package turnbough.transactions.controllers;

import org.springframework.web.bind.annotation.RestController;
import turnbough.transactions.services.TransactionService;

@RestController
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



}
