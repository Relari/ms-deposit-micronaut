package pe.francovargas.dao.mapper;

import pe.francovargas.dao.db.entity.TransactionEntity;
import pe.francovargas.model.domain.Transaction;

public class TransactionMapper {

    private TransactionMapper() {}

    public static TransactionEntity mapTransactionEntity(Transaction transaction) {
        return TransactionEntity.builder()
                .id(transaction.getId())
                .accountId(transaction.getAccountId())
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .build();
    }

    public static Transaction mapTransaction(TransactionEntity transactionEntity) {
        return Transaction.builder()
                .accountId(transactionEntity.getAccountId())
                .amount(transactionEntity.getAmount())
                .id(transactionEntity.getId())
                .type(transactionEntity.getType())
                .build();
    }



}
