package our.foundation.bank.controllerIntegration;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import our.foundation.bank.OurBankApplication;
import our.foundation.bank.entity.Account;
import our.foundation.bank.entity.Customer;
import our.foundation.bank.repository.AccountRepository;
import our.foundation.bank.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OurBankApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
class AccountControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private CustomerRepository custRepository;
	@Autowired
	private AccountRepository accRepository;

	private List<Account> accounts;
	private Customer c;

	@BeforeEach
	void setUp() throws Exception {

		accounts = new ArrayList<Account>();
		c = new Customer("sri", "SAP", "9087654321", "789065432154", new Date(2021 - 10 - 24));
		Account account = new Account(1, "SV", "123456789012", new Date(2021 - 10 - 24), BigDecimal.valueOf(2463), c);
		Account account1 = new Account(2, "FD", "123456789022", new Date(2021 - 10 - 24), BigDecimal.valueOf(2463), c);
		accounts.add(account);
		accounts.add(account1);

	}

	@AfterEach
	void Down() throws Exception {
		accounts = null;
	}

	@Test
	@Order(1)
	void getAllAccountsTest() throws Exception {
		custRepository.deleteAll();
		accRepository.deleteAll();
		// testing for failed scenario
		this.mockMvc.perform(get("/accounts/")).andExpect(status().isNotFound()).andDo(print())
				.andExpect(content().string(containsString("Accounts not Found")));
		// setup
		custRepository.save(c);
		accRepository.saveAll(accounts);
		// verify the output
		this.mockMvc.perform(get("/accounts/")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	@Order(2)
	void getAccount() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(get("/accounts/90/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Account id : 90 not Found")));
		// testing for passed scenario 
		ResultActions response = mockMvc.perform(get("/accounts/4/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(accounts.get(0))));

		response.andDo(print()).andExpect(status().isOk());

	}

	@Test
	@Order(3)
	void getAccountsBySearch() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(get("/accounts/search/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Account Details  not Found")));

		// testing for passed scenario
		ResultActions response = mockMvc
				.perform(get("/accounts/search/?accType=SV").contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(accounts.get(0))));

		response.andDo(print()).andExpect(status().isOk());
	}

	@Test
	@Order(4)
	void deleteAccount() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(delete("/accounts/8/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Unable to delete. Account with this id 8 not Found")));

		// testing for passed scenario
		this.mockMvc.perform(delete("/accounts/4/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("deleted account with this id : 4")));

	}

	@Test
	@Order(5)
	void deleteAllAccounts() throws Exception {
		// testing for passed scenario
		this.mockMvc.perform(delete("/accounts/deleteall/")).andDo(print()).andExpect(status().isNoContent())
				.andExpect(content().string(containsString("deleted all accounts")));
	}

}
