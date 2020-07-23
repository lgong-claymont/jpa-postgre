package com.wuyang.postgre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaPostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPostgresApplication.class, args);
		System.out.println("JPA Postgres Demo starts ...");
	}

}
