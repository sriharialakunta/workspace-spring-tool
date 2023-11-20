package our.foundation.bank.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import our.foundation.bank.entity.Account;
import our.foundation.bank.exception.ResourceAlreadyExistsException;
import our.foundation.bank.exception.ResourceNotFoundException;
import our.foundation.bank.service.AccountService;

@RestController
@RequestMapping("/accounts/")
@Slf4j
public class AccountController {

	private static final String ALREADY_EXIST = " already exist";
	private static final String RESPONDED = "RESPONDED";
	@Autowired
	private AccountService service;
	@Autowired
	private CustomerController custController;
	
	private HttpHeaders headers = new HttpHeaders();
	
	@GetMapping
	public ResponseEntity<List<Account>> findAllAccounts() {

		List<Account> accounts = service.findAllAccounts();
		if (accounts.isEmpty()) {
			log.error("EMPTY Accounts List");
			throw new ResourceNotFoundException("Accounts");
		}
		log.info("List Of Accounts");
		headers.add(RESPONDED, "All Accounts");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(accounts);
	}

	@GetMapping("{id}/")
	public ResponseEntity<Optional<Account>> getAccount(@PathVariable("id") int id) {

		Optional<Account> account = service.findAccountById(id);
		if (account.isEmpty()) {
			log.error("Account id : " + id + " not found");
			throw new ResourceNotFoundException("Account id : " + id);
		}
		log.info("Details Of Account " + id);
		headers.add(RESPONDED, "Account id " + id + "details");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(account);
	}

	@GetMapping("search/")
	public ResponseEntity<List<Account>> searchAccounts(@RequestParam(required = false) String accType,
			@RequestParam(required = false) String accNumber,
			@RequestParam(required = false, defaultValue = "0") int accBalance,
			@RequestParam(required = false, defaultValue = "nill") String range) {
		List<Account> accounts = service.searchAccounts(accType, accNumber, accBalance, range);

		if (accounts.isEmpty()) {
			log.error("Account Details  Not Found");
			throw new ResourceNotFoundException("Account Details ");
		}

		log.info("Getting Account Details");
		return new ResponseEntity<>(accounts, HttpStatus.OK);

	}

	@PostMapping("newaccount/")
	public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account, UriComponentsBuilder ucBuilder) {

		log.info("Creating New Account " + account.getAccNumber());
		// Check if the CUSTOMER already exist or not.
		custController.getCustomer(account.getCustomer().getCustId());
		// Check if the ACCOUNT NUMBER exist or not.
		if (!service.searchAccounts(null, account.getAccNumber(), 0, null).isEmpty()) {
			log.error("An Account with this " + account.getAccNumber() + ALREADY_EXIST);
			throw new ResourceAlreadyExistsException("An Account with these " + account.getAccNumber());
		} // Check if the ACCOUNT exist or not.
		else if (service.isAccountExist(account) != null) {
			log.error("An Account with this " + account.getAccType() + ALREADY_EXIST);
			throw new ResourceAlreadyExistsException("An Account with these " + account.getAccType());

		}
		// Creating ACCOUNT...
		Account acc = service.addAccount(account);
		headers.setLocation(ucBuilder.path("/account/{id}/").buildAndExpand(acc.getAccId()).toUri());
		headers.add(RESPONDED, "New Account Added ");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(acc);
	}

	@PutMapping("update/")
	public ResponseEntity<Account> updateAccount(@Valid @RequestBody Account account, UriComponentsBuilder ucBuilder) {
		log.info("Updating Account Details " + account.getAccNumber());
		
		// Check if the CUSTOMER already exist or not.
		custController.getCustomer(account.getCustomer().getCustId());
		// Check if the ACCOUNT NUMBER exist or not.
		Account acc = service.searchAccounts(null,account.getAccNumber(), 0, null).get(0);
		// Check if the CUSTOMER already exist or not.
		if (acc != null && service.isAccountExist(account) == null) {
			
			account.setAccId(acc.getAccId());
			headers.setLocation(ucBuilder.path("/account/{id}/").buildAndExpand(account.getAccId()).toUri());
			headers.add(RESPONDED, "Updated Account Details");
			return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(service.addAccount(account));
		}
		log.error("Account with this Account Type :" + account.getAccType() 
						+ " and Account Number "+account.getAccNumber()+ " Not Found");
		throw new ResourceNotFoundException("Account with this Account Type :" + account.getAccType() 
			+ " and Account Number "+account.getAccNumber());

	}

	@DeleteMapping("{id}/")
	public ResponseEntity<String> deleteAccountById(@PathVariable("id") int id) {

		log.info("Fetching & Deleting Account with id " + id);
		// Check if the ACCOUNT exist or not.
		if (service.findAccountById(id).isEmpty()) {
			log.error("Unable to delete. Account with this id " + id + " not found");
			throw new ResourceNotFoundException("Unable to delete. Account with this id " + id);
		}
		log.info("Deleted Account with this id " + id);
		headers.add(RESPONDED, "Deleted Account with this id : " + id);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(service.deleteAccountById(id));

	}

	@DeleteMapping("deleteall/")
	public ResponseEntity<String> deleteAllAccount() {

		log.info("Deleting All Accounts");
		headers.add(RESPONDED, "Deleted All Accounts");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).body(service.deleteAllAccounts());
	}

}
