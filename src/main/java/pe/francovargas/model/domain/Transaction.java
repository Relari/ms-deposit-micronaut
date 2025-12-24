package pe.francovargas.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.francovargas.model.api.TransactionRequest;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;
	private Double amount;
	private Currency currency;
	private TransactionType type;
	private String creationDate;
	private Integer idAccount;

	public Transaction(TransactionRequest request) {
		this.idAccount = request.getIdAccount();
		this.amount = request.getAmount();
		this.currency = Currency.valueOf(request.getCurrency());
		this.type = TransactionType.valueOf(request.getType().toUpperCase());
		this.creationDate = LocalDateTime.now().toString();
	}

}
