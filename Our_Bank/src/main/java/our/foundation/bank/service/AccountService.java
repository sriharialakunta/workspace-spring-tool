package our.foundation.bank.service;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import our.foundation.bank.entity.Account;

public interface AccountService {

	List<Account> findAllAccounts();

	Optional<Account> findAccountById(int id);

	String deleteAccountById(int id);

	String deleteAllAccounts();

	Account addAccount(@Valid Account account);

	Account isAccountExist(@Valid Account account);

	List<Account> searchAccounts(String accId, String accNumber, int accBalance, String range);

	int updateAccount(@Valid Account account);


}
