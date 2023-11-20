package our.foundation.bank.service;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import our.foundation.bank.entity.Customer;

public interface CustomerService {

	List<Customer> findAllCustomers();

	Customer addCustomer(@Valid Customer customer);

	Customer isCustomerExist(@Valid String aadhar);

	Optional<Customer> findCustomerById(int id);

	String deleteCustomerById(int id);

	String deleteAllCustomers();

	List<Customer> searchCustomers(String cName, String cAddress, String cPhone, String cAadhar);

}
