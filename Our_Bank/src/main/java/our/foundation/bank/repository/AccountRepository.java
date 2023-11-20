package our.foundation.bank.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import our.foundation.bank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM Account WHERE acc_type =?1 AND customer_id =?2")
	Account isAccountExist(String accType, int custId);

	List<Account> findByAccType(String accType);
	
	List<Account> findByAccNumber(String accNumber);

	List<Account> findByAccBalance(int accBalance);

	List<Account> findByAccDateOfIssue(Date accDateOfIssue);
	
	@Query(nativeQuery = true, value = "SELECT * FROM Account WHERE customer_id =?1")
	List<Account> findBycustomerId(int customerId);

	
	@Query(nativeQuery = true, value = "SELECT * FROM Account WHERE acc_balance BETWEEN (SELECT MIN(acc_balance) FROM Account) AND ?1")
	List<Account> findByMinAccBalance(int accBalance);
	@Query(nativeQuery = true, value = "SELECT * FROM Account WHERE acc_balance BETWEEN ?1 AND (SELECT MAX(acc_balance) FROM Account)")
	List<Account> findByMaxAccBalance(int accBalance);

	@Query(nativeQuery = true, value = "SELECT acc_balance FROM Account WHERE acc_number =?1")
	int findAccBalance(String accNumber);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(nativeQuery = true, value = "update Account set acc_balance=?1 where acc_number=?2")
	int updateBalance(BigDecimal balance,String accNumber);

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(nativeQuery = true, value = "update Account set acc_balance=?1, acc_type =?2"
			+ "  where acc_number=?3 AND customer_id =?4 ")
	int updateAccount(BigDecimal balance,String accType,String accNumber,int custId);


}
