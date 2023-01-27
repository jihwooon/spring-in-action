package com.example.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceExchageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceExchageApplication.class, args);
	}

}
