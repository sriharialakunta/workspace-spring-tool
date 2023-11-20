package our.foundation.bank.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
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
import our.foundation.bank.service.CustomerService;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService cservice;

	public List<Customer> customers;

	@BeforeEach
	public void customersList() {
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
	@AfterEach
	void Down() throws Exception {
		customers = null;
	}
	@Test
	void getAllCustomers() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(get("/customers/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Customers not Found")));

		// testing for passed scenario
		when(cservice.findAllCustomers()).thenReturn(customers);
		ResultActions response = mockMvc.perform(get("/customers/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customers)));

		response.andDo(print()).andExpect(status().isOk());

	}

	@Test
	void getCustomer() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(get("/customers/1/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Customer id : 1 not Found")));
		// testing for passed scenario
		when(cservice.findCustomerById(1)).thenReturn(Optional.of(customers.get(0)));
		ResultActions response = mockMvc.perform(get("/customers/1/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customers.get(0))));

		response.andDo(print()).andExpect(status().isOk());

	}

	@Test
	void getCustomersBySearch() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(get("/customers/search/?cName=SV")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Customer Details  not Found")));

	}

	@Test
	void deleteCustomer() throws Exception {
		this.mockMvc.perform(delete("/customers/1/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Unable to delete. Customer with this id : 1 not Found")));

		when(cservice.findCustomerById(1)).thenReturn(Optional.of(customers.get(0)));
		when(cservice.deleteCustomerById(customers.get(0).getCustId())).thenReturn("Deleted Customer with this id : 1");
		this.mockMvc.perform(delete("/customers/1/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Deleted Customer with this id : 1")));

	}

	@Test
	void deleteAllCustomers() throws Exception {
		when(cservice.deleteAllCustomers()).thenReturn("Deleted All Customers");
		this.mockMvc.perform(delete("/customers/deleteall/")).andDo(print()).andExpect(status().isNoContent())
				.andExpect(content().string(containsString("Deleted All Customers")));
	}

}
