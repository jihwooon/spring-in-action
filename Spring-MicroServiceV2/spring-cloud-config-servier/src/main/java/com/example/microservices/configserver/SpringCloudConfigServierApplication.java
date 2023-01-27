package com.example.microservices.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServierApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigServierApplication.class, args);
    }

}
