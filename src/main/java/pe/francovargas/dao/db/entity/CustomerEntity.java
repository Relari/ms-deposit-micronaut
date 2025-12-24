package pe.francovargas.dao.db.entity;

import io.micronaut.core.annotation.Creator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.francovargas.model.domain.Customer;
import pe.francovargas.model.domain.DocumentType;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor(onConstructor_ = {@Creator})
@NoArgsConstructor

@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Column(name = "document_number")
    private String documentNumber;
    @Column(name = "document_type")
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;
    @Column(name = "full_name")
    private String fullName;

    public CustomerEntity(Customer customer) {
        this.idCustomer = customer.getIdCustomer();
        this.documentNumber = customer.getDocumentNumber();
        this.documentType = customer.getDocumentType();
        this.fullName = customer.getFullName();
    }

}
