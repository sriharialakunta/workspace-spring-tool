package our.foundation.bank.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import our.foundation.bank.entity.Transaction;

public interface TransactionService {

	List<Transaction> findAllTransactions();

	Optional<Transaction> findById(int id);

	String deleteById(int id);

	String deleteAll();

	BigDecimal isAmountExist(String string);

	Transaction createTnx(@Valid Transaction tnx);

	boolean isAccountExist(String string);

}
