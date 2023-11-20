package our.foundation.bank.serviceimpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import our.foundation.bank.entity.Account;
import our.foundation.bank.repository.AccountRepository;
import our.foundation.bank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repository;

	@Override
	public List<Account> findAllAccounts() {
		return repository.findAll();
	}

	@Override
	public Optional<Account> findAccountById(int id) {
		return repository.findById(id);
	}

	@Override
	public String deleteAccountById(int id) {
		repository.deleteById(id);
		return "deleted account with this id : "+id;
	}

	@Override
	public String deleteAllAccounts() {
		repository.deleteAll();
		return "deleted all accounts";
	}

	@Override
	public Account addAccount(@Valid Account account) {
		return repository.save(account);
	}

	@Override
	public Account isAccountExist(@Valid Account account) {
			return repository.isAccountExist(account.getAccType(),account.getCustomer().getCustId());
	}

	@Override
	public List<Account> searchAccounts(String accType, String accNumber, int accBalance, String range) {
		if (accType != null)
			return repository.findByAccType(accType);
		else if (accNumber != null)
			return repository.findByAccNumber(accNumber);
		else if (String.valueOf(accBalance) != null && range != null)
			return findByAccBalance(accBalance, range);
		else
			return Collections.emptyList();

	}

	private List<Account> findByAccBalance(int accBalance, String range) {
		if (range.contains("MIN"))
			return repository.findByMinAccBalance(accBalance);
		else if (range.contains("MAX"))
			return repository.findByMaxAccBalance(accBalance);
		else
			return repository.findByAccBalance(accBalance);
	}

	@Override
	public int updateAccount(@Valid Account account) {
		
		return repository.updateAccount(account.getAccBalance(),account.getAccType(),account.getAccNumber(),account.getCustomer().getCustId());
	}


}
