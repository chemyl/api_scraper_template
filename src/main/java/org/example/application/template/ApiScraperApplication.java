package org.example.application.template;

import org.example.application.template.config.Routes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(Routes.class)
public class ApiScraperApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiScraperApplication.class);
    }
}