package com.kafkapractice.kafkapractice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {
    @Bean
    public NewTopic newTopic() {
        return new NewTopic("java", 2, (short) 1);
    }

}
