package our.foundation.bank.controllerIntegration;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import our.foundation.bank.entity.Transaction;
import our.foundation.bank.repository.AccountRepository;
import our.foundation.bank.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OurBankApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
class TransactionControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private CustomerRepository custRepository;
	@Autowired
	private AccountRepository accRepository;

	private List<Account> accounts;
	private List<Transaction> tnxs;
	private ResultActions response;
	private Customer c ;

	@BeforeEach
	void setUp() throws Exception {


		accounts = new ArrayList<Account>();
		c = new Customer("sri", "SAP", "9087654321", "789065432154", new Date(2021 - 10 - 24));
		Account account = new Account(1, "SV", "123456789012", new Date(2021 - 10 - 24), BigDecimal.valueOf(2463),c);
		Account account1 = new Account(2, "FD", "123456789022", new Date(2021 - 10 - 24), BigDecimal.valueOf(2463),c);
		accounts.add(account);
		accounts.add(account1);
		tnxs = new ArrayList<Transaction>();
		Transaction tnx = new Transaction();
		tnx.setAccNumber("123456789722");
		tnx.setBeneficiaryAccNo("123456789012");
		tnx.setAmountTransfer(BigDecimal.valueOf(24.3));
		
		Transaction tnx_1 = new Transaction();
		tnx_1.setAccNumber("123456789012");
		tnx_1.setBeneficiaryAccNo("123456789022");
		tnx_1.setAmountTransfer(BigDecimal.valueOf(24.63));
		
		Transaction tnx_2 = new Transaction();
		tnx_2.setAccNumber("123456789012");
		tnx_2.setBeneficiaryAccNo("123456789022");
		tnx_2.setAmountTransfer(BigDecimal.valueOf(2465));
		
		tnxs.add(tnx);
		tnxs.add(tnx_1);
		tnxs.add(tnx_2);
		
	}

	@AfterEach
	void Down() throws Exception {
		accounts = null;
		tnxs = null;
	}
	
	@Test
	@Order(0)
    void createTransactionTest() throws Exception{
		// testing for failed scenario for Invalid Customer Details...! 
		 response = mockMvc.perform(post("/tnxs/newtnx/").contentType(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(tnxs.get(0))));

			response.andDo(print()).andExpect(status().isNotFound())
			.andExpect(content().string(containsString("Invalid Customer Details...!  not Found")));
			
        // setup
		custRepository.save(c);
        accRepository.saveAll(accounts);
        //For Insufficient Fund......
        response = mockMvc.perform(post("/tnxs/newtnx/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(tnxs.get(2))));

		response.andDo(print()).andExpect(status().isConflict())
		.andExpect(content().string(containsString("Insufficient Fund : ₹2463 not Found")));
		
        //verify the output
        response = mockMvc.perform(post("/tnxs/newtnx/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(tnxs.get(1))));

		response.andDo(print()).andExpect(status().isCreated());
    }
	@Test
	@Order(6)
	void getAllTransactionsFaildTest() throws Exception{
		// testing for failed scenario
		this.mockMvc.perform(get("/tnxs/")).andExpect(status().isNotFound()).andDo(print())
			.andExpect(content().string(containsString("Transactions not Found")));
    }
	@Test
	@Order(1)
    void getAllTransactionsTest() throws Exception{
		response = mockMvc.perform(get("/tnxs/").contentType(MediaType.APPLICATION_JSON)
		.content(new ObjectMapper().writeValueAsString(tnxs.get(1))));
		response.andExpect(status().isOk()).andDo(print());
    }

	@Test
	@Order(2)
	void getTransaction() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(get("/tnxs/4/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Transaction id : 4 not Found")));
		// testing for passed scenario
		response = mockMvc.perform(get("/accounts/1/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(tnxs.get(1))));

		response.andDo(print()).andExpect(status().isOk());
		

	}

	@Test
	@Order(4)
	void deleteTransaction() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(delete("/tnxs/8/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Unable to delete. Transaction with this id : 8 not Found")));

		//testing for passed scenario
		this.mockMvc.perform(delete("/tnxs/1/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Deleted Transaction with this id : 1")));

	}

	@Test
	@Order(5)
	void deleteAllCustomers() throws Exception {
		//testing for passed scenario
		this.mockMvc.perform(delete("/accounts/deleteall/")).andDo(print()).andExpect(status().isNoContent())
				.andExpect(content().string(containsString("deleted all accounts")));
	}

}
