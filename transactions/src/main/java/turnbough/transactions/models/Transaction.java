package turnbough.transactions.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * Transaction. Used to model a personal-finance transaction.
 *
 * @author David Turnbough
 */
@Entity
public class Transaction
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	private BigDecimal transactionAmount;
	//TODO: Convert transactionDate from String to Date type
	private String transactionDate;
	private String transactionDescription;
	private String transactionCategory;

	@Enumerated(EnumType.STRING)
	private String transactionStatus;

	@Enumerated(EnumType.STRING)
	private String transactionType;


}
