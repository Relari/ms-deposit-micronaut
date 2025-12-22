package pe.francovargas.dao.impl;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import pe.francovargas.dao.TransactionDao;
import pe.francovargas.dao.db.repository.TransactionRepository;
import pe.francovargas.dao.mapper.TransactionMapper;
import pe.francovargas.model.domain.Transaction;

import static pe.francovargas.dao.mapper.TransactionMapper.mapTransactionEntity;

@Singleton
@AllArgsConstructor
public class TransactionDaoImpl implements TransactionDao {

    private final TransactionRepository transactionRepository;

    @Override
    public Single<Transaction> save(Transaction transaction) {
        return Single.fromCallable(() -> mapTransactionEntity(transaction))
                .map(transactionRepository::save)
                .subscribeOn(Schedulers.io())
                .map(TransactionMapper::mapTransaction);
    }

    @Override
    public Observable<Transaction> findAll() {
        return Observable.fromCallable(transactionRepository::findAll)
                .subscribeOn(Schedulers.io())
                .flatMapIterable(transactionEntities -> transactionEntities)
                .map(TransactionMapper::mapTransaction);
    }


}
