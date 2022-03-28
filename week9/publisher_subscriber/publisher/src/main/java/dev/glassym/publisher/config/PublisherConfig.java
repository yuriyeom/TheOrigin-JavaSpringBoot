package dev.glassym.publisher.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.JavaBean;

@Configuration
public class PublisherConfig {

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("boot.fanout.exchange");
    }
}
