/**
 * TransactionRepository. Used to query the database.
 *
 * @author David Turnbough
 */
package turnbough.transactions.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import turnbough.transactions.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>
{
}
