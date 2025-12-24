package pe.francovargas.controller;


//import io.micrometer.core.annotation.Timed;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.reactivex.Completable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import pe.francovargas.model.api.TransactionRequest;
import pe.francovargas.model.domain.Transaction;
import pe.francovargas.service.TransactionService;


@Controller(value = "/v1/deposits")
@AllArgsConstructor
public class DepositController {

	private final TransactionService service;

	@Post("/transactions")
//	@Timed(value = "postDepositEvent", histogram = true, percentiles = { 0.95, 0.99 }, extraTags = { "app",
//			"postDepositEvent" })
	@Status(HttpStatus.NO_CONTENT)
	public Completable registerTransaction(@Body TransactionRequest request) {
		return Single.fromCallable(() -> new Transaction(request))
				.flatMapCompletable(service::save);
	}

}
