package fr.isty.iatic5.archilog.sessions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.isty.iatic5.sessions.service.SessionImplementation;


@SpringBootApplication
public class App {

	public static void main(String[] args) {
		
		SessionImplementation.initDatabase(); 
		SpringApplication.run(App.class, args);
		

	}

}