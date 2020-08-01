package com.wuyang.postgre.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JpaPostgreDemoController {
	@GetMapping("/postgres")
	public String postgresDemoStart () {
		return "Jpa Postgres demo start...";
	}

}
