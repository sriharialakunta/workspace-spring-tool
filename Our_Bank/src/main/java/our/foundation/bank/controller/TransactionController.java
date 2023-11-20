package our.foundation.bank.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import our.foundation.bank.entity.Transaction;
import our.foundation.bank.exception.InsufficientBalance;
import our.foundation.bank.exception.ResourceNotFoundException;
import our.foundation.bank.service.TransactionService;

@RestController
@RequestMapping("/tnxs/")
@Slf4j
public class TransactionController {

	private static final String RESPONDED = "RESPONDED";

	@Autowired
	private TransactionService service;
	private HttpHeaders headers = new HttpHeaders();

	@GetMapping
	public ResponseEntity<List<Transaction>> findAllTransactions() {

		List<Transaction> transactions = service.findAllTransactions();
		if (transactions.isEmpty()) {
			log.error("EMPTY Transactions List");
			throw new ResourceNotFoundException("Transactions");
		}
		log.info("List Of Transactions");
		headers.add(RESPONDED, "All Transactions");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(transactions);
	}

	@GetMapping("{id}/")
	public ResponseEntity<Optional<Transaction>> getTransaction(@PathVariable("id") int id) {

		Optional<Transaction> transaction = service.findById(id);
		if (transaction.isEmpty()) {
			log.error(id + " Transaction id not found");
			throw new ResourceNotFoundException("Transaction id : " + id);
		}
		log.info("Details Of Transaction " + id);
		headers.add(RESPONDED, "Transaction id " + id + "details");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(transaction);
	}

	@PostMapping("newtnx/")
	public ResponseEntity<Transaction> createTnx(@Valid @RequestBody Transaction tnx, UriComponentsBuilder ucBuilder) {

		log.info("Creating New Transaction " + tnx.getAccNumber());

		if ((service.isAccountExist(tnx.getAccNumber()) && service.isAccountExist(tnx.getBeneficiaryAccNo())
				&& !tnx.getAccNumber().equals(tnx.getBeneficiaryAccNo()))) {
			BigDecimal fund = service.isAmountExist(tnx.getAccNumber());
			
			if(tnx.getAmountTransfer().compareTo(BigDecimal.ZERO)<=0)
				throw new ResourceNotFoundException("Please Enter Positive Number...! ");
			
			if (fund.compareTo(tnx.getAmountTransfer())>0) {
				Transaction transaction = service.createTnx(tnx);
				headers.setLocation(ucBuilder.path("/tnx/{id}").buildAndExpand(transaction.getTId()).toUri());
				headers.add(RESPONDED, "New Transaction Created ");
				return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(transaction);
			} else {
				log.error("Insufficient Fund");
				throw new InsufficientBalance("Insufficient Fund : ₹" + fund);
			}
		}
		log.error("Invalid Customer Details ");
		throw new ResourceNotFoundException("Invalid Customer Details...! ");

	}

	@DeleteMapping("{id}/")
	public ResponseEntity<String> deleteTransactionById(@PathVariable("id") int id) {

		log.info("Fetching & Deleting Transaction with id " + id);
		Optional<Transaction> transaction = service.findById(id);
		if (transaction.isEmpty()) {
			log.error("Unable to delete. Transaction with this id " + id + " not found");
			throw new ResourceNotFoundException("Unable to delete. Transaction with this id : " + id);
		}

		log.info("Deleted Transaction with this id " + id);
		headers.add(RESPONDED, "Deleted Transaction with this id : " + id);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(service.deleteById(id));

	}

	@DeleteMapping("deleteall/")
	public ResponseEntity<String> deleteAllTransactions() {

		log.info("Deleting All Transactions");
		headers.add(RESPONDED, "Deleted All Transactions");

		return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).body(service.deleteAll());
	}

}
