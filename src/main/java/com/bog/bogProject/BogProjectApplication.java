package com.bog.bogProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class BogProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BogProjectApplication.class, args);
	}

}
