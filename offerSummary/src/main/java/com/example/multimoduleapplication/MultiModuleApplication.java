package com.example.multimoduleapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = { "com.example.multimodulelibrary", "com.example.multimoduleapplication" })
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MultiModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiModuleApplication.class, args);
	}

}
