package pe.francovargas.dao.db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import pe.francovargas.model.domain.Currency;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="account")
public class AccountEntity implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAccount ;
	@Column(name="total_amount")
	private double totalAmount ;
	@Column(name="currency")
	@Enumerated(EnumType.STRING)
	private Currency currency ;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_customer" , referencedColumnName = "id_customer", nullable = false)
	@Fetch(FetchMode.JOIN)
	private CustomerEntity customer;

}