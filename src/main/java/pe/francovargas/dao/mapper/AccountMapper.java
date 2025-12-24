package pe.francovargas.dao.mapper;

import pe.francovargas.dao.db.entity.AccountEntity;
import pe.francovargas.dao.db.entity.CustomerEntity;
import pe.francovargas.model.domain.Account;
import pe.francovargas.model.domain.Customer;

public class AccountMapper {

    private AccountMapper() {}

    public static Account mapAccount(AccountEntity accountEntity) {
        return Account.builder()
                .idAccount(accountEntity.getIdAccount())
                .totalAmount(accountEntity.getTotalAmount())
                .currency(accountEntity.getCurrency())
                .customer(new Customer(accountEntity.getCustomer()))
                .build();
    }

    public static AccountEntity mapAccountEntity(Account account) {
        return AccountEntity.builder()
                .idAccount(account.getIdAccount())
                .totalAmount(account.getTotalAmount())
                .currency(account.getCurrency())
                .customer(new CustomerEntity(account.getCustomer()))
                .build();
    }

}
