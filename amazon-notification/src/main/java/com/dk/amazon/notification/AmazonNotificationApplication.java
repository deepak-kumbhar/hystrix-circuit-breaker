package com.dk.amazon.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/notification")
public class AmazonNotificationApplication {

	@GetMapping("/customer")
	public String sendNotification() {
		return "Notification sent to the customer";
	}

	
	public static void main(String[] args) {
		SpringApplication.run(AmazonNotificationApplication.class, args);
	}
}
