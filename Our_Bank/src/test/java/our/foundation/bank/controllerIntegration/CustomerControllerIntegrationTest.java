package our.foundation.bank.controllerIntegration;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import our.foundation.bank.entity.Customer;
import our.foundation.bank.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OurBankApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(org.junit.jupiter.api.MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
class CustomerControllerIntegrationTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private CustomerRepository custRepository;

	private List<Customer> customers;
	private ResultActions response;

	@BeforeEach
	void setUp() throws Exception {

		customers = new ArrayList<Customer>();
		Customer cust = new Customer("Sri", "SAP", "9087654321", "789065432134", new Date(2021 - 10 - 24));
		Customer cust1 = new Customer("Venu", "GNT","3123574321","678335672154", new Date(2020 - 07 - 17));
		customers.add(cust);
		customers.add(cust1);
	}

	@AfterEach
	void Down() throws Exception {
		customers = null;
	}

	@Test
	@Order(0)
    void createCustomerTest() throws Exception{
		
		custRepository.deleteAll();
//		this.mockMvc.perform(get("/customer/")).andExpect(status().isOk()).andDo(print());
		response = mockMvc.perform(post("/customers/newcustomer/").contentType(MediaType.APPLICATION_JSON)
					.content(new ObjectMapper().writeValueAsString(customers.get(0))));
					response.andDo(print()).andExpect(status().isCreated());
		// testing for failed scenario for Invalid Customer Details...! 
		response = mockMvc.perform(post("/customers/newcustomer/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customers.get(0))));
					response.andDo(print()).andExpect(status().isConflict())
					.andExpect(content().string(containsString("A customer with this Aadhar number : 789065432134 Already Exists")));
    }
	
	@Test
	@Order(1)
    void getAllCustomersTest() throws Exception{
        // setup
        custRepository.save(customers.get(1));
        //verify the output
        this.mockMvc.perform(get("/customers/")).andExpect(status().isOk()).andDo(print());
    }

	@Test
	@Order(2)
	void getCustomer() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(get("/customers/7/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Customer id : 7 not Found")));
		// testing for passed scenario
		ResultActions response = mockMvc.perform(get("/customers/2/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customers.get(1))));

		response.andDo(print()).andExpect(status().isOk());
		

	}

	@Test
	@Order(3)
	void getCustomersBySearch() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(get("/customers/search/?cName=SL")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Customer Details  not Found")));

	}

	@Test
	@Order(4)
	void deleteCustomer() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(delete("/customers/8/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Unable to delete. Customer with this id : 8 not Found")));

		//testing for passed scenario
		this.mockMvc.perform(delete("/customers/2/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Deleted customer with this id : 2")));

	}

	@Test
	@Order(5)
	void deleteAllCustomers() throws Exception {
		//testing for passed scenario
		this.mockMvc.perform(delete("/customers/deleteall/")).andDo(print()).andExpect(status().isNoContent())
				.andExpect(content().string(containsString("Deleted all customers")));
	}

}
