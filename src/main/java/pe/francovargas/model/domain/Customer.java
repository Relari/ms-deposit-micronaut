package pe.francovargas.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.francovargas.dao.db.entity.CustomerEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private Integer idCustomer;
    private String documentNumber;
    private DocumentType documentType;
    private String fullName;

    public Customer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer(CustomerEntity entity) {
        this.idCustomer = entity.getIdCustomer();
        this.documentNumber = entity.getDocumentNumber();
        this.documentType = entity.getDocumentType();
        this.fullName = entity.getFullName();
    }

}
