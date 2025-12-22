package pe.francovargas.service;

import io.reactivex.Observable;
import io.reactivex.Single;
import pe.francovargas.model.domain.Transaction;

public interface TransactionService {

    Single<Transaction> save(Transaction transaction);

    Observable<Transaction> findAll();
}
