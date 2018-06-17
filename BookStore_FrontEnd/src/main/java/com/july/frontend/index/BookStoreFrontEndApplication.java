package com.july.frontend.index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.july.frontend")
public class BookStoreFrontEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreFrontEndApplication.class, args);
	}
}
