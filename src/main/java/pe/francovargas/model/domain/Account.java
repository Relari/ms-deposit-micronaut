package pe.francovargas.model.domain;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Integer idAccount;
    private double totalAmount;
    private Currency currency;
    private Customer customer;

}
