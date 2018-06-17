package com.july.backend.index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.july.backend")
public class BookStoreBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreBackEndApplication.class, args);
	}
}
