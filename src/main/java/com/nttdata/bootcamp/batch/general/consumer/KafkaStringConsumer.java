package com.nttdata.bootcamp.batch.general.consumer;


import com.nttdata.bootcamp.batch.general.domain.ClientEntity;
import com.nttdata.bootcamp.batch.general.domain.dto.QuantityProductOpenClientRequest;
import com.nttdata.bootcamp.batch.general.domain.service.ClientDWService;
import com.nttdata.bootcamp.batch.general.domain.service.ClienteService;
import com.nttdata.bootcamp.batch.general.persistence.model.entity.Client;
import io.reactivex.rxjava3.core.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
@Component
public class KafkaStringConsumer {
    Logger logger = LoggerFactory.getLogger(KafkaStringConsumer.class);
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClientDWService clientDWService;

    @KafkaListener(topics = "TOPIC-PRODUCTOS-APERTURADO" , groupId = "group_id")
    public void consume(String message) {
        Gson gson = new Gson();
        QuantityProductOpenClientRequest notificationEmailRequest =
                gson.fromJson(message, QuantityProductOpenClientRequest.class);

        ClientEntity clientEntity=ClientEntity.builder()
                .codeClient(notificationEmailRequest.getCodeClient())
                .quantityProduct(notificationEmailRequest.getQuantityProduct())
                .build();

                clienteService.save(clientEntity)
                        .subscribe(s -> logger.info("Actualizar cantidad de producto "+ s.getCodeClient())) ;


                /// Registrar en DataWhereHouse

        Client clien =Client.builder()
                .codClient(notificationEmailRequest.getCodeClient())
                .quantityProduct(notificationEmailRequest.getQuantityProduct())
                .build();

        clientDWService.save(clien);


    }

}
