package turnbough.transactions.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * Transaction. Used to model a personal-finance transaction.
 *
 * @author David Turnbough
 */
@Entity
@Table(name = "transaction")
public class Transaction
{

	//*****
	// Variables
	//*****
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;

	@JsonProperty("transaction_amount")
	private BigDecimal transactionAmount;

	//TODO: Convert transactionDate from String to Date type
	@JsonProperty("transaction_date")
	private String transactionDate;

	@JsonProperty("transaction_description")
	private String transactionDescription;

	@Enumerated(EnumType.STRING)
	@JsonProperty("transaction_category")
	private TransactionCategory transactionCategory;

	@Enumerated(EnumType.STRING)
	@JsonProperty("transaction_status")
	private TransactionStatus transactionStatus;

	@Enumerated(EnumType.STRING)
	@JsonProperty("transaction_type")
	private TransactionType transactionType;

	public Transaction()
	{
	}

	public Transaction(Long transactionId)
	{
		this.transactionId = transactionId;
	}

	//*****
	// Constructors
	//*****
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

	//*****
	// Getter Methods
	//*****
	public Long getTransactionId()
	{
		return transactionId;
	}

	public BigDecimal getTransactionAmount()
	{
		return transactionAmount;
	}

	public String getTransactionDate()
	{
		return transactionDate;
	}

	public String getTransactionDescription()
	{
		return transactionDescription;
	}

	public TransactionCategory getTransactionCategory()
	{
		return transactionCategory;
	}

	public TransactionStatus getTransactionStatus()
	{
		return transactionStatus;
	}

	public TransactionType getTransactionType()
	{
		return transactionType;
	}

	//*****
	// Setter Methods
	//*****
	public void setTransactionId(Long transactionId)
	{
		this.transactionId = transactionId;
	}

	public void setTransactionAmount(BigDecimal transactionAmount)
	{
		this.transactionAmount = transactionAmount;
	}

	public void setTransactionDate(String transactionDate)
	{
		this.transactionDate = transactionDate;
	}

	public void setTransactionDescription(String transactionDescription)
	{
		this.transactionDescription = transactionDescription;
	}

	public void setTransactionCategory(TransactionCategory transactionCategory)
	{
		this.transactionCategory = transactionCategory;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus)
	{
		this.transactionStatus = transactionStatus;
	}

	public void setTransactionType(TransactionType transactionType)
	{
		this.transactionType = transactionType;
	}


}
