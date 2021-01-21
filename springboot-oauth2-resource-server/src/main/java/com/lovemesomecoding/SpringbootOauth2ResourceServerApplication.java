package com.lovemesomecoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class SpringbootOauth2ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootOauth2ResourceServerApplication.class, args);
	}

}
