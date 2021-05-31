package com.benmorant.bankingapp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class BankingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingappApplication.class, args);
		System.out.println("http://localhost:8060/bankingapp/index.html");
	}

}
