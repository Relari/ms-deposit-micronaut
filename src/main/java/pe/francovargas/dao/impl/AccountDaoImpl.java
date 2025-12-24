package pe.francovargas.dao.impl;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import pe.francovargas.dao.AccountDao;
import pe.francovargas.dao.db.repository.AccountRepository;
import pe.francovargas.dao.mapper.AccountMapper;
import pe.francovargas.model.domain.Account;


@Singleton
@AllArgsConstructor
public class AccountDaoImpl implements AccountDao {

    private final AccountRepository accountRepository;

    @Override
    public Completable update(Account account) {
        return Single.fromCallable(() -> AccountMapper.mapAccountEntity(account))
                .map(accountRepository::update)
                .subscribeOn(Schedulers.io())
                .ignoreElement();
    }

    @Override
    public Single<Account> findById(Integer id) {
        return Single.fromCallable(() -> accountRepository.findById(id).orElse(null))
                .subscribeOn(Schedulers.io())
                .map(AccountMapper::mapAccount);
    }

}
