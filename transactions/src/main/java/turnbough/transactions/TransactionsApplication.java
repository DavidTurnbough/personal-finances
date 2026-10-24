package turnbough.transactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * An application to keep track of personal-finance transactions.
 *
 * @author David Turnbough
 */
@SpringBootApplication
public class TransactionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}

}
