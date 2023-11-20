package our.foundation.bank.serviceimpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import our.foundation.bank.entity.Transaction;
import our.foundation.bank.repository.AccountRepository;
import our.foundation.bank.repository.TransactionRepository;
import our.foundation.bank.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository repository;
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Transaction> findAllTransactions() {
		return repository.findAll();
	}

	@Override
	public Optional<Transaction> findById(int id) {
		return repository.findById(id);
	}

	@Override
	public String deleteById(int id) {
		repository.deleteById(id);
		return "Deleted Transaction with this id : "+id;
	}

	@Override
	public String deleteAll() {
		repository.deleteAll();
		return "Deleted all Transactions";
	}

	@Override
	public boolean isAccountExist(String accNumber) {
		return !accountRepository.findByAccNumber(accNumber).isEmpty();
	}

	@Override
	public BigDecimal isAmountExist(String string) {
		return BigDecimal.valueOf(accountRepository.findAccBalance(string));
	}

	@Override
	public Transaction createTnx(@Valid Transaction tnx) {

		accountRepository.updateBalance(isAmountExist(tnx.getAccNumber()).subtract(tnx.getAmountTransfer()),
				tnx.getAccNumber());
		accountRepository.updateBalance(isAmountExist(
				tnx.getBeneficiaryAccNo()).add(tnx.getAmountTransfer()),
				tnx.getBeneficiaryAccNo());
		tnx.setRemaningBalance(isAmountExist(tnx.getAccNumber()));
		tnx.setTnxDate(new Date());
		return repository.save(tnx);
	}

}
