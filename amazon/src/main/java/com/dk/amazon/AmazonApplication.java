package com.dk.amazon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableHystrix
@RestController
@EnableHystrixDashboard
public class AmazonApplication {

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@HystrixCommand(groupKey = "amazon sample", commandKey = "amazon sample", fallbackMethod = "bookIphoneFallbackMethod")
	@GetMapping("/iphone")
	public String bookIphone() {
		String pay = restTemplate.getForObject("http://localhost:8002/payment/card", String.class);
		String notification = restTemplate.getForObject("http://localhost:8001/notification/customer", String.class);
		return pay + "\n" + notification;
	}

	public String bookIphoneFallbackMethod() {
		return restTemplate.getForObject("http://localhost:8002/payment/card", String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AmazonApplication.class, args);
	}

}
