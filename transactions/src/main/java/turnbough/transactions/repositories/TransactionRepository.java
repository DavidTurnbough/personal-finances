/**
 * TransactionRepository. Used to query the database.
 *
 * @author David Turnbough
 */
package turnbough.transactions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import turnbough.transactions.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>
{
}
