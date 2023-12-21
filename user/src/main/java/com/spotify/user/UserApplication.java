package com.spotify.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserApplication {

	@RequestMapping("/")
	public String home() {
		return "Home Page";
	}

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	// @Bean
	// public WebClient webclient() {
	// 	return webclient.builder().build();
	// }
}
