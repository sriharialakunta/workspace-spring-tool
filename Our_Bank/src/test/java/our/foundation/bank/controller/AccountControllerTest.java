package our.foundation.bank.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import our.foundation.bank.entity.Account;
import our.foundation.bank.entity.Customer;
import our.foundation.bank.service.AccountService;
import our.foundation.bank.service.CustomerService;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService service;
	@MockBean
	private CustomerService cservice;
	@MockBean
	private CustomerController controller;
	public Customer customer;
	public List<Account> accounts;

	@BeforeEach
	public void accounts() {

		accounts = new ArrayList<Account>();
		Customer c = new Customer("sri", "SAP", "9087654321", "789065432154", new Date(2021 - 10 - 24));
		Account account = new Account(1, "SV", "123456789012", new Date(2021 - 10 - 24), BigDecimal.valueOf(2463),c);
		Account account1 = new Account(2, "FD", "123456789022", new Date(2021 - 10 - 24), BigDecimal.valueOf(2463),c);
		accounts.add(account);
		accounts.add(account1);

	}

	@Test
	void getAllAccounts() throws Exception {
		
		this.mockMvc.perform(get("/accounts/")).andDo(print()).andExpect(status().isNotFound())
		.andExpect(content().string(containsString("Accounts not Found")));
		
		when(service.findAllAccounts()).thenReturn(accounts);
		ResultActions response=mockMvc.perform(get("/accounts/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(accounts)));
				
		response.andDo(print()).andExpect(status().isOk());
		

	}

	@Test
	void getAccount() throws Exception {
		
		this.mockMvc.perform(get("/accounts/1/")).andDo(print()).andExpect(status().isNotFound())
		.andExpect(content().string(containsString("Account id : 1 not Found")));
		
		when(service.findAccountById(1)).thenReturn(Optional.of(accounts.get(0)));
		ResultActions response=mockMvc.perform(get("/accounts/1/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(accounts.get(0))));
				
		response.andDo(print()).andExpect(status().isOk());
		
	}

	@Test
	void getAccountsBySearch() throws Exception {
		
		this.mockMvc.perform(get("/accounts/search/?accId=SV")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Account Details  not Found")));
		
	}

	@Test
	void addAccount() throws Exception {
		
		when(cservice.findCustomerById(accounts.get(0).getCustomer().getCustId())).thenReturn(Optional.of(accounts.get(0).getCustomer()));
		when(service.searchAccounts(null, accounts.get(0).getAccNumber(), 0, null)).thenReturn(Collections.emptyList());
		when(service.isAccountExist(accounts.get(0))).thenReturn(null);
		when(service.addAccount(accounts.get(0))).thenReturn(accounts.get(0));
		
		ResultActions response=mockMvc.perform(post("/accounts/newaccount/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(accounts.get(0))));
				
		response.andDo(print()).andExpect(status().isCreated());
		
		}

	@Test
	void deleteAccount() throws Exception {
		
		this.mockMvc.perform(delete("/accounts/1/")).andDo(print()).andExpect(status().isNotFound())
		.andExpect(content().string(containsString("Unable to delete. Account with this id 1 not Found")));

		when(service.findAccountById(1)).thenReturn(Optional.of(accounts.get(0)));
		when(service.deleteAccountById(1)).thenReturn("deleted account with this id : 1");
		this.mockMvc.perform(delete("/accounts/1/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("deleted account with this id : 1")));


	}

	@Test
	void deleteAllAccounts() throws Exception {
		when(service.deleteAllAccounts()).thenReturn("Deleted All Accounts");
		this.mockMvc.perform(delete("/accounts/deleteall/")).andDo(print()).andExpect(status().isNoContent())
				.andExpect(content().string(containsString("Deleted All Accounts")));

	}

}
