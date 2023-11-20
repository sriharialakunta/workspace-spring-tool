package our.foundation.bank.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;
	@NotNull@NotBlank
	@Pattern(regexp = "^[0-9]{12}$",message = "Please Enter 12 Digit Account Number...")
	private String accNumber;
	@NotNull@NotBlank
	@Pattern(regexp = "^[0-9]{12}$",message = "Please Enter 12 Digit Account Number...")
	private String beneficiaryAccNo;
	@NotNull
	@Column(scale = 2)
	private BigDecimal amountTransfer;
	@Column(scale = 2)
	private BigDecimal remaningBalance;
	private Date tnxDate;
	

}
