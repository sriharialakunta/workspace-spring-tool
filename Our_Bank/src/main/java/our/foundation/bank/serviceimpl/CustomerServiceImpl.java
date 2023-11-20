package our.foundation.bank.serviceimpl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import our.foundation.bank.entity.Customer;
import our.foundation.bank.repository.CustomerRepository;
import our.foundation.bank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository repository;

	@Override
	public List<Customer> findAllCustomers() {
		return repository.findAll();
	}

	@Override
	public Customer addCustomer(@Valid Customer customer) {
		return repository.save(customer);
	}

	@Override
	public Customer isCustomerExist(@Valid String aadhar) {
		return repository.isCustomerExist(aadhar);
	}

	@Override
	public Optional<Customer> findCustomerById(int id) {
		return repository.findById(id);
	}

	@Override
	public String deleteCustomerById(int id) {
		repository.deleteById(id);
		return "Deleted customer with this id : "+id;
	}

	@Override
	public String deleteAllCustomers() {
		repository.deleteAll();
		return "Deleted all customers";
	}

	@Override
	public List<Customer> searchCustomers(String cName, String cAddress, String cPhone, String cAadhar) {
		if (!cName.isBlank())
			return repository.findByName(cName);
		else if (!cAddress.isBlank())
			return repository.findByAddress(cAddress);
		else if (!cPhone.isBlank())
			return repository.findByPhone(cPhone);
		else if (!cAadhar.isBlank())
			return (List.of(repository.isCustomerExist(cAadhar)));
		else
			return Collections.emptyList();
	}


}
