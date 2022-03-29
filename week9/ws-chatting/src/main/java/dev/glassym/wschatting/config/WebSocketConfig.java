package dev.glassym.wschatting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // STOMP 기반 웹소켓 메시징 가능
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 클라이언트가 최초로 접근하는 웹소켓의 엔드포인트
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws/chat");
        registry.addEndpoint("/ws/chat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/receive-endpoint");
        registry.setApplicationDestinationPrefixes("/send-endpoint");
    }
}
