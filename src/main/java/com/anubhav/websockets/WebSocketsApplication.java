package com.anubhav.websockets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class WebSocketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSocketsApplication.class, args);
	}
}
