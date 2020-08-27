package com.cargotracker.handling.application.internal.outboundservices;

import com.cargotracker.handling.infrastructure.brokers.rabbitmq.CargoEventSource;
import com.cargotracker.shareddomain.events.CargoHandledEvent;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 *
 */
@Service
@EnableBinding(CargoEventSource.class)
public class CargoEventPublisherService {

    CargoEventSource cargoEventSource;

    public CargoEventPublisherService(CargoEventSource cargoEventSource){
        this.cargoEventSource = cargoEventSource;
    }

    @TransactionalEventListener
    public void handleCargoHandledEvent(CargoHandledEvent cargoHandledEvent){
        cargoEventSource.cargoHandling1().send(MessageBuilder.withPayload(cargoHandledEvent).build());
        cargoEventSource.cargoHandling2().send(MessageBuilder.withPayload(cargoHandledEvent).build());
    }
}