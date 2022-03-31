package dev.glassym.webclient.service;

import dev.glassym.webclient.model.ActuatorLoggerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@Service
public class ActuatorService {
    private static final Logger logger = LoggerFactory.getLogger(ActuatorService.class);
    private final WebClient actuatorClient;

    public ActuatorService(WebClient actuatorClient) {
        this.actuatorClient = actuatorClient;
    }

    // 로그 레벨을 설정할 수 있는 액츄에이터 엔드포인트
    public void setServerLogLevel(String loggerName,String logLevel){
        // config의 baseUrl 뒤에 붙는다.
        String uri = String.format("/loggers/%s", loggerName);
        // 요청을 준비하는 과정
        ResponseEntity<?> bodiless = this.actuatorClient
                .post()
                .uri(uri)
                // body 전달. config에서 json이라고 해줘서 이 객체를 json으로 만들어서 전달
                .bodyValue(new ActuatorLoggerDto(logLevel))
                // 응답 처리를 정의
                .retrieve()
                .onStatus(
                        HttpStatus::is4xxClientError, clientResponse -> {
                            logger.error(clientResponse.statusCode().toString());
                            // mono 객체를 반환해야하는데 에러가 아닌 것처럼 하고싶으면
                            return Mono.empty();
                        })
                .onStatus(HttpStatus::is5xxServerError, clientResponse ->
                    Mono.error(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR)))
                // 응답에서 바디를 제외한 status line과 header들이 정의된 responseEntity에 응답을 준다.
                .toBodilessEntity() // HTTP Response Body
                .block();

    }

    public void shutdownServer(){
        String uri = "/shutdown";
        ResponseEntity<?> bodiless = this.actuatorClient
                .post()
                .uri(uri)
                .retrieve() // 응답을 받아올 준비
                .onStatus(HttpStatus::is4xxClientError, clientResponse ->
                        Mono.error(new ResponseStatusException(clientResponse.statusCode())))
                .toBodilessEntity()
                .block();
    }
}
