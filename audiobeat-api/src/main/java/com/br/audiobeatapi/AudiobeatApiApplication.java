package com.br.audiobeatapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.br.audiobeatapi.*")
public class AudiobeatApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudiobeatApiApplication.class, args);
	}

}
