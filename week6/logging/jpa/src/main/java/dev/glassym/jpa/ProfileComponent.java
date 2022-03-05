package dev.glassym.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local") // 해당 프로파일 일때만 이 빈이 생성되도록
public class ProfileComponent {

    private static final Logger logger = LoggerFactory.getLogger(ProfileComponent.class);
    public ProfileComponent(){
        logger.info("profile component profile: local");
    }
}
