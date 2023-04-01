package com.br.audiobeatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.br.audiobeatapi.*")
public class AudiobeatApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudiobeatApiApplication.class, args);
	}

}
