package pe.francovargas.service.impl;

import io.reactivex.Completable;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import pe.francovargas.dao.AccountDao;
import pe.francovargas.kafka.producer.ExternalProducer;
import pe.francovargas.model.domain.Transaction;
import pe.francovargas.service.TransactionService;
import pe.francovargas.util.JsonConverter;

@Singleton
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	private final AccountDao accountDao;
	private final ExternalProducer externalProducer;

//	private DepositEventProducer eventProducer;
	
	@Override
	public Completable save(Transaction transaction) {
		return accountDao.findById(transaction.getIdAccount())
				.filter(account -> account.getCurrency() == transaction.getCurrency())
				.map(account -> {
					double newAmount = switch (transaction.getType()) {
						case DEPOSIT -> account.getTotalAmount() + transaction.getAmount();
						case WITHDRAWAL -> account.getTotalAmount() - transaction.getAmount();
                    };
					account.setTotalAmount(newAmount);
					return account;
				})
				.flatMapCompletable(accountDao::update)
				.andThen(externalProducer.sendMessage(JsonConverter.toJson(transaction)).ignoreElement());
	}

}
