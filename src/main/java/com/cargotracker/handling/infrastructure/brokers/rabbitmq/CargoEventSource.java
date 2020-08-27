package com.cargotracker.handling.infrastructure.brokers.rabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Interface depicting all output channels
 */
public interface CargoEventSource {
    @Output("cargoHandlingChannel1")
    MessageChannel cargoHandling1();
    
    @Output("cargoHandlingChannel2")
    MessageChannel cargoHandling2();
}