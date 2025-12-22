package pe.francovargas.service.impl;

import io.reactivex.Observable;
import io.reactivex.Single;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import pe.francovargas.dao.TransactionDao;
import pe.francovargas.kafka.producer.ExternalProducer;
import pe.francovargas.model.domain.Transaction;
import pe.francovargas.service.TransactionService;
import pe.francovargas.util.JsonConverter;

@Singleton
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

	private final TransactionDao transactionDao;
	private final ExternalProducer externalProducer;

//	private DepositEventProducer eventProducer;
	
	@Override
	public Single<Transaction> save(Transaction transaction) {
		return transactionDao.save(transaction)
				.flatMap(transaction1 -> externalProducer.sendMessage(
							JsonConverter.toJson(transaction1))
						.map(response -> transaction1)
				);
	}

	@Override
	public Observable<Transaction> findAll() {
		return transactionDao.findAll();
	}

}
