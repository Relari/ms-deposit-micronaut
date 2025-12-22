package pe.francovargas.model.api;

import io.micronaut.serde.annotation.Serdeable;
import lombok.*;
import pe.francovargas.model.domain.Transaction;

import java.io.Serial;
import java.io.Serializable;

@Serdeable
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private Integer id;
	private double amount ;
	private String type ;	
	private Integer accountId ;

	public TransactionResponse(Transaction transaction) {
		this.accountId = transaction.getAccountId();
		this.amount = transaction.getAmount();
		this.id = transaction.getId();
		this.type = transaction.getType();
	}

}
