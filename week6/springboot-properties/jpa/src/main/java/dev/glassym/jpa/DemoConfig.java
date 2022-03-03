package dev.glassym.jpa;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

// 스프링 부트에서 제공하지않는, 자기가 만들지않은 라이브러리 클래스를 빈으로 제공
// 설정에 필요한 클래스들을 객체화해서 IoC 컨테이너에 전달
@Configuration
public class DemoConfig {
    private static final Logger logger = LoggerFactory.getLogger(DemoConfig.class);

    // yml 파일에 있는 값이 변수에 들어간다.
    @Value("${custom.property.single}")
    private String customProperty;

    @Value("${custom.property.comlist}")
    private List<String> customCommaList;

    @Value("${custom.property.default:default-property}")
    private String propertyDefault;

    @PostConstruct
    public void init(){
        logger.info("custom property: {}", customProperty);

        for(String commaListItem: customCommaList){
            logger.info("comma list item: {}", commaListItem);
        }
        logger.info("default property: {}", propertyDefault);
    }

    @Bean
    public Gson gson(){
        return new Gson(); // IoC 컨테이너에게 넘겨준다.
    }
}
