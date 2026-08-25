package com.fundoo.notes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

    // Name of the queue used for the async-email use case. Also pre-created
    // by spring.artemis.embedded.queues in application.properties.
    public static final String EMAIL_QUEUE = "email.queue";

    /**
     * By default Spring JMS uses Java serialization for object messages,
     * which is brittle (both sides need the exact same class) and a known
     * security smell. Sending JSON text instead is the standard fix.
     */
    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
