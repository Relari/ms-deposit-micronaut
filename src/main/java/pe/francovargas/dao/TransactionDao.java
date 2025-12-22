package pe.francovargas.dao;

import io.reactivex.Observable;
import io.reactivex.Single;
import pe.francovargas.model.domain.Transaction;

public interface TransactionDao {

    Single<Transaction> save(Transaction transaction);

    Observable<Transaction> findAll();
}
