package com.ironhack.proxybooksservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProxyBooksServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyBooksServiceApplication.class, args);
	}

}
