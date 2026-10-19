/*
 * PURPOSE:
 * AUTHOR: David Turnbough
 */
package turnbough.accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import turnbough.accounts.models.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long>
{

	boolean existsByAccountName(String accountName);

	Account findByAccountName(String accountName);
	List<Account> getAccountsByAccountType(String accountType);
}
