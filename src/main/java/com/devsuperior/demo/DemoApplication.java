package com.devsuperior.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void run(){
		System.out.println("ENCODE = " + passwordEncoder.encode("123456"));
		boolean result = passwordEncoder.matches("12356","$2a$10$k6bVJ5iQ7xKzoZOlxofbj.bJEGMoyiZRBtmZ5nX3iAW3Cf2b8gas6");
		System.out.println("RESULTADO = " + result);
	}
}
