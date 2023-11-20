package our.foundation.bank.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int accId;
	@NotNull@NotBlank
	@Pattern(regexp = "^(SV|FD|DM|CR|SA)$",message = "Plz enter valid account type.")
	private String accType;
	@NotNull@NotBlank
	@Pattern(regexp = "^[0-9]{12}$",message = "Please Enter 12 Digit Account Number...")
	private String accNumber;
	@NotNull
	private Date accDateOfIssue;
	@NotNull
	@Column(scale = 2)
	private BigDecimal accBalance;

    @ManyToOne
    @JsonIgnoreProperties("accounts")
    @JoinColumn(name="customer_id")
	private Customer customer;
	
	
}
