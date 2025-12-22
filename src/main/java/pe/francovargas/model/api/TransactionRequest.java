package pe.francovargas.model.api;

import io.micronaut.serde.annotation.Serdeable;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Serdeable
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Double amount;
	private String type;
	private Integer accountId;

}
