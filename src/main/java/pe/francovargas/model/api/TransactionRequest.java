package pe.francovargas.model.api;

import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serial;
import java.io.Serializable;

@Serdeable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	@NotNull
	private Double amount;

	@NotNull
	@NotBlank
	private String currency;

	@Pattern(regexp = "^(deposit|withdrawal)$", message = "Type must be either DEPOSIT or WITHDRAWAL")
	private String type;

	@NotNull
	private Integer idAccount;

}
