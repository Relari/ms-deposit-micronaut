package pe.francovargas.dao;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import pe.francovargas.model.domain.Account;

public interface AccountDao {

    Single<Account> findById(Integer id);
    Completable update(Account account);

}
