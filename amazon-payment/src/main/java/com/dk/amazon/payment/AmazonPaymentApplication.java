package com.dk.amazon.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/payment")
public class AmazonPaymentApplication {

	@GetMapping("/card")
	public String payViaCard() {
		return "Payment done by card";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AmazonPaymentApplication.class, args);
	}
}
