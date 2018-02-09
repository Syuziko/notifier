package com.sflpro.notifier.queue.consumer.notification.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Company: SFL LLC
 * Created on 08/02/2018
 *
 * @author Davit Harutyunyan
 */
@Configuration
@ConditionalOnProperty(name = "queue.engine", havingValue = "rabbit")
@ImportResource("classpath:applicationContext-queue-consumer-amqp.xml")
public class QueueConsumerConditionalConfiguration {
}
