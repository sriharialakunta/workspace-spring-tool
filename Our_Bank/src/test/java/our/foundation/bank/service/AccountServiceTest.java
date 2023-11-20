package our.foundation.bank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import our.foundation.bank.entity.Account;
import our.foundation.bank.entity.Customer;
import our.foundation.bank.repository.AccountRepository;
import our.foundation.bank.serviceimpl.AccountServiceImpl;

@SpringBootTest
class AccountServiceTest {

	@Mock
	AccountRepository repository;

	@InjectMocks
	AccountServiceImpl accImpl;

	public List<Account> accounts;

	@BeforeEach
	public void accounts() {
		accounts = new ArrayList<Account>();
		Customer a = new Customer();
		a.setCustId(1);
		Account account = new Account(1, "SV", "123456789012", new Date(2021 - 10 - 24), BigDecimal.valueOf(2463), a);
		Account account1 = new Account(2, "FD", "123456789022", new Date(2021 - 10 - 24), BigDecimal.valueOf(2463), a);
		accounts.add(account);
		accounts.add(account1);
	}

	@DisplayName("JUnit test for getAllAccounts method")
	@Test
	void test_getAllAccounts() {

		when(repository.findAll()).thenReturn(accounts);
		assertEquals(accounts, accImpl.findAllAccounts());
	}

	@DisplayName("JUnit test for getByAccountId method")
	@Test
	void test_getByAccountId() {
		when(repository.findByAccType("FD")).thenReturn(List.of(accounts.get(1)));
		List<Account> acc = accImpl.searchAccounts("FD", null, 0, null);
		assertEquals(accounts.get(1), acc.get(0));
	}

	@DisplayName("JUnit test for saveAccount method")
	@Test
	void test_saveAccount() {
		when(repository.save(accounts.get(0))).thenReturn(accounts.get(0));
		assertEquals(accounts.get(0), accImpl.addAccount(accounts.get(0)));
	}

	@DisplayName("JUnit test for deleteAccount method")
	@Test
	void test_deleteAccount() {
		assertEquals("deleted account with this id : 1", accImpl.deleteAccountById(1));
	}

	@DisplayName("JUnit test for deleteAllAccounts method")
	@Test
	void test_deleteAllAccounts() {
		assertEquals("deleted all accounts", accImpl.deleteAllAccounts());
	}
}
