package pe.francovargas.model.domain;

import lombok.*;
import pe.francovargas.model.api.TransactionRequest;

import java.io.Serial;
import java.io.Serializable;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Double amount;
	private String type ;	
	private Integer accountId ;


	public Transaction(TransactionRequest transactionRequest) {
		this.accountId = transactionRequest.getAccountId();
		this.amount = transactionRequest.getAmount();
		this.id = transactionRequest.getId();
		this.type = transactionRequest.getType();
	}

}
