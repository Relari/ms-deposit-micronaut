package pe.francovargas.service;

import io.reactivex.Completable;
import pe.francovargas.model.domain.Transaction;

public interface TransactionService {

    Completable save(Transaction transaction);

}
