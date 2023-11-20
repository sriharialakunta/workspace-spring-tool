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
import our.foundation.bank.entity.Customer;
import our.foundation.bank.exception.ResourceAlreadyExistsException;
import our.foundation.bank.exception.ResourceNotFoundException;
import our.foundation.bank.service.CustomerService;

@RestController
@RequestMapping("/customers/")
@Slf4j
public class CustomerController {

	private static final String RESPONDED = "RESPONDED";
	@Autowired
	private CustomerService service;
	private HttpHeaders headers = new HttpHeaders();

	@GetMapping
	public ResponseEntity<List<Customer>> findAllCustomers() {

		List<Customer> customersList = service.findAllCustomers();
		if (customersList.isEmpty()) {
			log.error("EMPTY Customers List");
			throw new ResourceNotFoundException("Customers");
		}
		log.info("List Of Customers");
		headers.add(RESPONDED, "All Customers");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customersList);
	}

	@GetMapping("{id}/")
	public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable("id") int id) {

		Optional<Customer> customer = service.findCustomerById(id);
		if (customer.isEmpty()) {
			log.error(id + " not found");
			throw new ResourceNotFoundException("Customer id : " + id);
		}
		log.info("customerId " + id + " Details");
		headers.add(RESPONDED, "Customer id " + id + "details");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(customer);
	}

	@GetMapping("search/")
	public ResponseEntity<List<Customer>> searchCustomers(@RequestParam(required = false) String cName,
			@RequestParam(required = false) String cAddress, @RequestParam(required = false) String cPhone,
			@RequestParam(required = false) String cAadhar) {
		List<Customer> accounts = service.searchCustomers(cName, cAddress, cPhone, cAadhar);

		if (!accounts.isEmpty()) {
			log.info("Getting Customer Details");
			return new ResponseEntity<>(accounts, HttpStatus.OK);
		}

		log.error("Customer Details  Not Found");
		throw new ResourceNotFoundException("Customer Details ");
	}

	@PostMapping("newcustomer/")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer,
			UriComponentsBuilder ucBuilder) {
		log.info("Creating New Customer " + customer.getCustName());

		if (service.isCustomerExist(customer.getCustAadhar())!=null) {
			log.error("A customer with this " + customer.getCustAadhar() + " already exist");
			throw new ResourceAlreadyExistsException(
					"A customer with this Aadhar number : " + customer.getCustAadhar());
		}
		Customer customers = service.addCustomer(customer);
		headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customers.getCustId()).toUri());
		headers.add(RESPONDED, "New Customer Added ");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(customers);
	}

	@PutMapping("updatecustomer/")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer,
			UriComponentsBuilder ucBuilder) {
		log.info("Updating Customer Details of this aadhar : " + customer.getCustAadhar());

		if (service.isCustomerExist(customer.getCustAadhar()) != null 
				&& getCustomer(customer.getCustId()).hasBody()) {
			
			headers.setLocation(ucBuilder.path("/customer/{id}").buildAndExpand(customer.getCustId()).toUri());
			headers.add(RESPONDED, "Updated Customer Details");
			return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(service.addCustomer(customer));
		}
		log.error(String.format("Customer with this aadhar : %s not found", customer.getCustAadhar()));
		throw new ResourceNotFoundException("Customer with this aadhar : " + customer.getCustAadhar());

	}

	@DeleteMapping("{id}/")
	public ResponseEntity<String> deleteCustomerById(@PathVariable("id") int id) {

		log.info("Fetching & Deleting User with id " + id);
		Optional<Customer> customer = service.findCustomerById(id);
		if (customer.isEmpty()) {
			log.error("Unable to delete. Customer with this id " + id + " not found");
			throw new ResourceNotFoundException("Unable to delete. Customer with this id : " + id);
		}
		log.info("Deleted Customer with this id " + id);
		headers.add(RESPONDED, "Deleted Customer with this id " + id);
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(service.deleteCustomerById(id));

	}

	@DeleteMapping("deleteall/")
	public ResponseEntity<String> deleteAllCustomer() {

		log.info("Deleting All Customers");
		headers.add(RESPONDED, "Deleted All Customers");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).body(service.deleteAllCustomers());
	}

}
