package com.tbiss.hroof;

import com.tbiss.hroof.config.FileStorageProperties;
import com.tbiss.hroof.controller.v1.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class HroofApplication {

    static  Logger logger = LoggerFactory.getLogger(HroofApplication.class);

    public static void main(String[] args) {
        logger.info("Run Spring Boot Application");
        SpringApplication.run(HroofApplication.class, args);
    }

}

