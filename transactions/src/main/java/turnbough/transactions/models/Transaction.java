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

	@Enumerated(EnumType.STRING)
	private TransactionCategory transactionCategory;

	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus;

	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;

	/**
	 *
	 * @param transactionAmount The amount of the transaction
	 * @param transactionDate The date of the transaction
	 * @param transactionDescription A brief description of the transaction
	 * @param transactionCategory The category of the transaction
	 * @param transactionStatus The status of the transaction (paid, due, etc.)
	 * @param transactionType The type of the transaction (debit, credit card, etc.)
	 */
	public Transaction( BigDecimal transactionAmount, String transactionDate, String transactionDescription, TransactionCategory transactionCategory, TransactionStatus transactionStatus, TransactionType transactionType)
	{
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionDescription = transactionDescription;
		this.transactionCategory = transactionCategory;
		this.transactionStatus = transactionStatus;
		this.transactionType = transactionType;
	}
}
