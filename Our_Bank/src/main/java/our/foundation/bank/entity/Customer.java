package our.foundation.bank.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	@NotNull@NonNull@NotBlank
	private String custName;
	@NotNull@NonNull@NotBlank
	private String custAddress;
	@NotNull@NonNull
	@Pattern(regexp = "^[0-9]{10}$",message ="Please Enter 10 Digits Mobile Number...")
	private String custPhone;
	@NotNull@NonNull
	@Pattern(regexp = "^[0-9]{12}$",message ="Please Enter 12 Digits Aadhar Number...")
	private String custAadhar;
	@NotNull@NonNull
	private Date custDOB;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("customer")
	private List<Account> accounts;
	
}
