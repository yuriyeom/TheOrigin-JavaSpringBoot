package dev.glassym.mission3_basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Mission3BasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(Mission3BasicApplication.class, args);
    }

}
