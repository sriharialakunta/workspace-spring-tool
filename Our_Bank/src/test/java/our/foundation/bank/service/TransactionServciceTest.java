package our.foundation.bank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import our.foundation.bank.entity.Transaction;
import our.foundation.bank.repository.AccountRepository;
import our.foundation.bank.repository.TransactionRepository;
import our.foundation.bank.serviceimpl.TransactionServiceImpl;
@SpringBootTest
class TransactionServciceTest {

	@Mock
	TransactionRepository repository;
	@Mock
	AccountRepository accRepository;

	@InjectMocks
	TransactionServiceImpl accImpl;

	public List<Transaction> tnxs;

	@BeforeEach
	public void accounts() {
		tnxs = new ArrayList<Transaction>();
		Transaction tnx = new Transaction();
					tnx.setTId(1);
					tnx.setAccNumber("123456789013");
					tnx.setBeneficiaryAccNo("123456789012");
					tnx.setAmountTransfer(BigDecimal.valueOf(4.63));
					tnx.setTnxDate(new Date());
					tnx.setRemaningBalance(BigDecimal.valueOf(2463));
		Transaction tnx_1 = new Transaction();tnx.setTId(2);
					tnx_1.setAccNumber("123456789012");
					tnx_1.setBeneficiaryAccNo("123456789013");
					tnx_1.setAmountTransfer(BigDecimal.valueOf(63.1));
					tnx.setTnxDate(new Date());
					tnx.setRemaningBalance(BigDecimal.valueOf(99.00));
		tnxs.add(tnx);
		tnxs.add(tnx_1);
	}

	@DisplayName("JUnit test for getAllTransactions method")
	@Test
	void test_getAllTransactions() {

		when(repository.findAll()).thenReturn(tnxs);
		assertEquals(tnxs, accImpl.findAllTransactions());
	}

	@DisplayName("JUnit test for getByTransactionId method")
	@Test
	void test_getByTransactionId() {
		when(repository.findById(1)).thenReturn(Optional.of(tnxs.get(1)));
		assertEquals(tnxs.get(1), accImpl.findById(1).get());
	}

	@DisplayName("JUnit test for saveTransaction method")
	@Test
	void test_saveTransaction() {
		
		
		when(repository.save(tnxs.get(0))).thenReturn(tnxs.get(0));
		when(accRepository.findAccBalance(tnxs.get(0).getAccNumber())).thenReturn(100000);
		assertEquals(tnxs.get(0), accImpl.createTnx(tnxs.get(0)));
	}

	@DisplayName("JUnit test for deleteTransaction method")
	@Test
	void test_deleteTransaction() {
		assertEquals("Deleted Transaction with this id : 1", accImpl.deleteById(1));
	}

	@DisplayName("JUnit test for deleteAllTransactions method")
	@Test
	void test_deleteAllTransactions() {
		assertEquals("Deleted all Transactions", accImpl.deleteAll());
	}
}
