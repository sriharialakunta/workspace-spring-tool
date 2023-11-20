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

import our.foundation.bank.entity.Transaction;
import our.foundation.bank.service.AccountService;
import our.foundation.bank.service.TransactionService;

@WebMvcTest(TransactionController.class)
class TransactionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService aservice;
	
	@MockBean
	private TransactionService service;

	public List<Transaction> tnxs;

	@BeforeEach
	public void accounts() {

		tnxs = new ArrayList<Transaction>();
		Transaction tnx = new Transaction();
//		tnx.setTId(1);
		tnx.setAccNumber("123456789013");
		tnx.setBeneficiaryAccNo("123456789012");
		tnx.setAmountTransfer(BigDecimal.valueOf(24.3));
		tnx.setTnxDate(new Date());
		tnx.setRemaningBalance(BigDecimal.valueOf(2463));
		Transaction tnx_1 = new Transaction();
		tnx.setTId(2);
		tnx_1.setAccNumber("123456789012");
		tnx_1.setBeneficiaryAccNo("123456789013");
		tnx_1.setAmountTransfer(BigDecimal.valueOf(24.63));
		tnx.setTnxDate(new Date());
		tnx.setRemaningBalance(BigDecimal.valueOf(2463));
		tnxs.add(tnx);
		tnxs.add(tnx_1);

	}

	@Test
	void getAllTransactions() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(get("/tnxs/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Transactions not Found")));

		// testing for passed scenario
		when(service.findAllTransactions()).thenReturn(tnxs);
		ResultActions response = mockMvc.perform(get("/tnxs/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(tnxs)));

		response.andDo(print()).andExpect(status().isOk());

	}

	@Test
	void getTransaction() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(get("/tnxs/1/")).andDo(print()).andExpect(status().isNotFound())
				.andExpect(content().string(containsString("Transaction id : 1 not Found")));

		// testing for passed scenario
		when(service.findById(1)).thenReturn(Optional.of(tnxs.get(0)));
		ResultActions response = mockMvc.perform(get("/tnxs/1/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(tnxs.get(0))));

		response.andDo(print()).andExpect(status().isOk());

	}

	@Test
	void addTransaction() throws Exception {
		// testing with passing invalid details
		ResultActions resp = mockMvc.perform(post("/tnxs/newtnx/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(tnxs.get(0))));
		resp.andDo(print()).andExpect(status().isNotFound())
		.andExpect(
				content().string(containsString("Invalid Customer Details...!  not Found")));

		// testing with Valid details
		when(service.isAccountExist(tnxs.get(0).getAccNumber())).thenReturn(true);
		when(service.isAccountExist(tnxs.get(0).getBeneficiaryAccNo())).thenReturn(true);
		when(service.isAmountExist(tnxs.get(0).getAccNumber())).thenReturn(BigDecimal.valueOf(143));
		when(service.createTnx(tnxs.get(0))).thenReturn(tnxs.get(0));
		ResultActions response = mockMvc.perform(post("/tnxs/newtnx/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(tnxs.get(0))));

		response.andDo(print()).andExpect(status().isCreated());

		//testing for the negative fund tnx
		tnxs.get(0).setAmountTransfer(BigDecimal.valueOf(-130));
		when(service.isAccountExist(tnxs.get(0).getAccNumber())).thenReturn(true);
		when(service.isAccountExist(tnxs.get(0).getBeneficiaryAccNo())).thenReturn(true);
		when(service.isAmountExist(tnxs.get(0).getAccNumber())).thenReturn(BigDecimal.valueOf(143));
		when(service.createTnx(tnxs.get(0))).thenReturn(tnxs.get(0));
		ResultActions finalresponse = mockMvc.perform(post("/tnxs/newtnx/").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(tnxs.get(0))));

		finalresponse.andDo(print()).andExpect(status().isNotFound())
		.andExpect(
				content().string(containsString("Please Enter Positive Number...!  not Found")));

	}

	@Test
	void deleteTransaction() throws Exception {
		// testing for failed scenario
		this.mockMvc.perform(delete("/tnxs/1/")).andDo(print()).andExpect(status().isNotFound()).andExpect(
				content().string(containsString("Unable to delete. Transaction with this id : 1 not Found")));

		// testing for passed scenario
		when(service.findById(1)).thenReturn(Optional.of(tnxs.get(0)));
		when(service.deleteById(1)).thenReturn("Deleted Transaction with this id : 1");
		this.mockMvc.perform(delete("/tnxs/1/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Deleted Transaction with this id : 1")));

	}

	@Test
	void deleteAllTransactions() throws Exception {
		when(service.deleteAll()).thenReturn("Deleted All Transactions");
		this.mockMvc.perform(delete("/tnxs/deleteall/")).andDo(print()).andExpect(status().isNoContent())
				.andExpect(content().string(containsString("Deleted All Transactions")));

	}

}
