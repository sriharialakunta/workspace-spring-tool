package our.foundation.bank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
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
import org.mockito.MockitoAnnotations;

import our.foundation.bank.entity.Account;
import our.foundation.bank.entity.Customer;
import our.foundation.bank.repository.CustomerRepository;
import our.foundation.bank.serviceimpl.CustomerServiceImpl;

class CustomerServiceTest {

	@Mock
	private CustomerRepository repository;

	@InjectMocks
	private CustomerServiceImpl service;

	public List<Customer> customers;

	@BeforeEach
	public void customersList() {
		MockitoAnnotations.openMocks(this);
		customers = new ArrayList<Customer>();
		Customer cId = new Customer();
		cId.setCustId(1);
		Account account = new Account(1, "SV", "123456789012", new Date(2021 - 10 - 24), BigDecimal.valueOf(2463), cId);
		Account account1 = new Account(2, "FD", "123456789022", new Date(2021 - 10 - 24), BigDecimal.valueOf(2463), cId);
		Customer cust = new Customer(1, "Sri", "SAP", "9087654321", "789065432134", new Date(2021 - 10 - 24),
				List.of(account, account1));
		Customer cId2 = new Customer();
		cId2.setCustId(2);
		Account account2 = new Account(2, "CU", "123456789014", new Date(2021 - 10 - 24), BigDecimal.valueOf(2463), cId2);
		Customer cust1 = new Customer(2, "Sri", "SAP", "9087654321", "789065432154", new Date(2021 - 10 - 24),
				List.of(account2));
		customers.add(cust);
		customers.add(cust1);
	}

	@DisplayName("JUnit test for getAllCustomers method")
	@Test
	void test_getAllCustomers() {

		when(repository.findAll()).thenReturn(customers);
		assertEquals(customers, service.findAllCustomers());
	}

	@DisplayName("JUnit test for getByCustomerId method")
	@Test
	void test_getByCustomerId() {
		when(repository.findById(customers.get(0).getCustId())).thenReturn(Optional.of(customers.get(0)));
		assertEquals(customers.get(0), service.findCustomerById(customers.get(0).getCustId()).get());
	}

	@DisplayName("JUnit test for getByCustomerAadhar method")
	@Test
	void test_isCustomerExist() {
		when(repository.isCustomerExist(customers.get(0).getCustAadhar())).thenReturn(customers.get(0));
		assertEquals(customers.get(0), service.isCustomerExist(customers.get(0).getCustAadhar()));
	}

	@DisplayName("JUnit test for getByCustomerAadhar method")
	@Test
	void test_findByName() {
		when(repository.findByName(customers.get(0).getCustName())).thenReturn(List.of(customers.get(0)));
		assertEquals(List.of(customers.get(0)), service.searchCustomers(customers.get(0).getCustName(),""," "," "));
	}

	@DisplayName("JUnit test for saveCustomer method")
	@Test
	void test_saveCustomer() {

		given(repository.save(customers.get(0))).willReturn(customers.get(0));
		assertEquals(customers.get(0), service.addCustomer(customers.get(0)));
	}

	@DisplayName("JUnit test for deleteCustomer method")
	@Test
	void test_deleteAccount() {

		assertEquals("Deleted customer with this id : 1", service.deleteCustomerById(1));
	}

	@DisplayName("JUnit test for deleteAllCustomers method")
	@Test
	void test_deleteAllAccounts() {

		assertEquals("Deleted all customers", service.deleteAllCustomers());
	}
}
