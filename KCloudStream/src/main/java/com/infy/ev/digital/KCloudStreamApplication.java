package com.infy.ev.digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.function.Function;

@SpringBootApplication
@ComponentScan
public class KCloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(KCloudStreamApplication.class, args);
	}

	@Bean
	public Function<String, String> uppercase() {
		return value -> value.toUpperCase();
	}
}
