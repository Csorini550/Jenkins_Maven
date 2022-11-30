package com.example.day14apexmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com")
public class Day14ApexMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day14ApexMvcApplication.class, args);
	}

}
