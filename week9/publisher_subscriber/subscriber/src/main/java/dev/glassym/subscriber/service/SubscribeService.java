package dev.glassym.subscriber.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "#{autoGenQueue.name}")
public class SubscribeService {
    private static final Logger logger = LoggerFactory.getLogger(SubscribeService.class);

    @RabbitHandler
    public void receiveMessage(String messageRaw){
        logger.info("Received: {}", messageRaw);
    }

}
