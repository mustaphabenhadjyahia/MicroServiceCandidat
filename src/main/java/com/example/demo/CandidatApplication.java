package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CandidatApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidatApplication.class, args);
	}	
	@Bean
		ApplicationRunner init(CandidatRepository repository) {
			return args -> {
				Stream.of("mustapha","aziz","adem").forEach(nom -> {
					repository.save(new Candidat(nom));
				});
				
				repository.findAll().forEach(System.out::println);
			};
			
		}
	}
