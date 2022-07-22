package com.ironhack.proxyloanedbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProxyLoanedBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyLoanedBookServiceApplication.class, args);
	}

}
