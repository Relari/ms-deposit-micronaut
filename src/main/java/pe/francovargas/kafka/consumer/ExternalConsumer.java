package pe.francovargas.kafka.consumer;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.reactivex.Flowable;

@KafkaListener(
        clientId = "ms-deposit-micronaut-consumer",
        groupId = "external-group"
//        batch = true
)
public class ExternalConsumer {

//    @Topic("external-topic")
//    void receive(String dataJson) {
//        System.out.println("Received transaction in external consumer: " + dataJson);
//    }

    @Topic("external-topic")
    void receive(Flowable<String> dataJson) {
        dataJson.subscribe(data ->
        System.out.println("Received transaction in external consumer: " + data)
        ).dispose();
    }

}
