package com.assessment.skuservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SkuServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkuServiceApplication.class, args);
	}

}
