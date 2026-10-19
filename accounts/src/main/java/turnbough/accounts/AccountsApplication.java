/*
 * PURPOSE: Driver class. An application used to keep track of personal finances.
 * AUTHOR: David Turnbough
 */
package turnbough.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * CLASS: Accounts Application
 * PURPOSE: Contains the main method.
 */
@SpringBootApplication
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
