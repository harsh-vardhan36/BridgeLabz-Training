package com.fundoo.notes.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ topology. Runs alongside the embedded Artemis/JMS broker
 * configured in JmsConfig -- the two are independent and don't share
 * queues or messages.
 *
 * Two use cases:
 *   1. Email (RabbitEmailProducer / RabbitEmailListener) -- a second path
 *      to the SAME outcome as JMS's EmailProducer/EmailListener, wired up
 *      in parallel so you can watch both brokers handle the same kind of
 *      job side by side (RabbitMQ management UI vs JMS logs).
 *   2. Note activity / audit trail (NoteActivityProducer / NoteActivityListener)
 *      -- a new use case JMS isn't used for. Uses a topic exchange with
 *      routing keys like "note.created", "note.archived", etc., which is a
 *      good contrast to JMS's simple point-to-point queue.
 */
@Configuration
public class RabbitConfig {

    // ---- Email (parallel path to JmsConfig.EMAIL_QUEUE) ----
    public static final String EMAIL_EXCHANGE = "fundoo.email.exchange";
    public static final String EMAIL_QUEUE = "fundoo.email.queue";
    public static final String EMAIL_ROUTING_KEY = "email.send";

    // ---- Note activity / audit trail ----

    
    // JSON over the wire (matches the Jackson converter used for JMS in
    // JmsConfig), so messages are human-readable in the management UI
    // instead of Java-serialized bytes.
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

//    @Bean
//    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
//                                          MessageConverter jsonMessageConverter) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(jsonMessageConverter);
//        return template;
//    }

    // ----- Email exchange / queue / binding -----

    @Bean
    public DirectExchange emailExchange() {
        return new DirectExchange(EMAIL_EXCHANGE);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue(EMAIL_QUEUE, true); // durable: survives a broker restart
    }

    @Bean
    public Binding emailBinding() {
        return BindingBuilder.bind(emailQueue()).to(emailExchange()).with(EMAIL_ROUTING_KEY);
    }

    // ----- Activity exchange / queue / binding -----


}
