package our.foundation.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import our.foundation.bank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	@Query(nativeQuery = true , value="select * from customer where cust_aadhar=?1")
	Customer isCustomerExist(String custAadhar);
	@Query(nativeQuery = true , value="select * from customer where cust_name=?1")
	List<Customer> findByName(String custName);
	@Query(nativeQuery = true , value="select * from customer where cust_address=?1")
	List<Customer> findByAddress(String custAddress);
	@Query(nativeQuery = true , value="select * from customer where cust_phone=?1")
	List<Customer> findByPhone(String custPhone);
	

}
