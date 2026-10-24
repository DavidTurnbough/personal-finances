/**
 * Transaction. Used to model a personal-finance transaction.
 *
 * @author David Turnbough
 */
package turnbough.transactions.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Transaction
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	private BigDecimal transactionAmount;
	private String transactionDate;
	private String transactionDescription;

	private String transactionType;
}
