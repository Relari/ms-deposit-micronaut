package pe.francovargas.controller;


//import io.micrometer.core.annotation.Timed;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import pe.francovargas.model.api.TransactionRequest;
import pe.francovargas.model.api.TransactionResponse;
import pe.francovargas.model.domain.Transaction;
import pe.francovargas.service.TransactionService;


@Controller("/v1/deposits")
@AllArgsConstructor
public class DepositController {

	private final TransactionService service;

	@Post
//	@ResponseStatus(HttpStatus.CREATED)
//	@Timed(value = "postDepositEvent", histogram = true, percentiles = { 0.95, 0.99 }, extraTags = { "app",
//			"postDepositEvent" })
	@Status(HttpStatus.NO_CONTENT)
	public Single<TransactionResponse> postDepositEvent(
			@Body TransactionRequest transactionRequest) {
		return Single.fromCallable(() -> new Transaction(transactionRequest))
				.flatMap(service::save)
				.map(TransactionResponse::new);
	}

	@Get
	public Observable<TransactionResponse> getAll() {
		return service.findAll().map(TransactionResponse::new);
	}

}
