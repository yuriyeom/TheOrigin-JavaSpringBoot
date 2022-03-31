package dev.glassym.webclient.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${ncp.api.access-key:stub-api-key}")
    private String accessKey;

    // 가장 자유로운 형태
    @Bean
    public WebClient defaultWebClient(){
        return WebClient.create();
    }

    @Bean
    public WebClient actuatorClient(){
        return WebClient.builder()
                .baseUrl("http://localhost:8081/actuator")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public WebClient ncpWebClient(){
        return WebClient.builder()
                .defaultHeader("x-ncp-iam-access-key", accessKey)
                .build();
    }

    // 응답의 JSON의 key(=필드명)가 snake case(_사용)형태로 들어오는데
    // 전환해서 java 객체로 넘겨주는 역할
    // jackson 라이브러리 사용. Spring에 기본 빈이 있어서 자동으로 autowired됨
    @Bean
    public WebClient randomDataClient(ObjectMapper baseConfig){
        // 기본 설정값을 복사해온다.
        ObjectMapper newMapper = baseConfig.copy();
        // JSON의 key를 어떤식으로 이름을 바꿀것인가 전략
        // java의 property들이 snake case로 변경된다.
        newMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        // ExchangeStrategies : 위 전략을 WebClient에 전달해주기 위한 객체
        ExchangeStrategies exchangeStrategies = ExchangeStrategies.builder()
                .codecs(configurer ->
                        configurer.defaultCodecs().jackson2JsonDecoder(new Jackson2JsonDecoder(newMapper)))
                .build();

        return WebClient.builder()
                .baseUrl("https://random-data-api.com")
                .exchangeStrategies(exchangeStrategies)
                .build();
    }

}
