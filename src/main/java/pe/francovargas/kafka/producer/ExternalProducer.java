package pe.francovargas.kafka.producer;

import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.reactivex.Single;

@KafkaClient(id = "ms-deposit-micronaut-producer")
public interface ExternalProducer {

//    @Topic("external-topic")
//    void sendMessage(String dataJson);

    @Topic("external-topic")
    Single<String> sendMessage(String dataJson);

}
